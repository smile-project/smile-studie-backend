package de.smile_studie.restcontroller;

import de.smile_studie.model.Questionaire;
import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.repository.QuestionaireRepository;
import de.smile_studie.security.JwtTokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by mss on 03.09.17.
 */
@RestController
public class QuestionaireController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public QuestionaireRepository questionaireRepository;

    @Autowired
    public QuestionaireAnswerRepository questionaireAnswerRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/questionaire", method = RequestMethod.GET)
    public Questionaire answer(@RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        QuestionaireAnswer lastAnswer = questionaireAnswerRepository.lastQuestionaireIdForUser(user.getId());

        // no questionaires yet
        if (lastAnswer == null) {
            logger.info("/questionaire: User " + user.getUsername() + " has no entries yet. Returning Q1");
            return questionaireRepository.findOne(1L);
        }

        // first week
        if (user.getState() == 0) {
            // we are not done with our first round of questionaires
            if (lastAnswer.getQuestionaireId() < 6L) {
                logger.info("/questionaire: User " + user.getUsername() +
                        " is in first week. Returning Q" + (lastAnswer.getQuestionaireId() + 1));
                return questionaireRepository.findOne(lastAnswer.getQuestionaireId() + 1);
            }
        }

        // first week done
        if (user.getState() == 1) {
            // we are done with the first round, check if a week has passed
            if (lastAnswer.getQuestionaireId() == 6L) {
                if (timePassed(lastAnswer.getTimestamp())) {
                    logger.info("/questionaire: User " + user.getUsername() +
                            " is past first week and waited 7 days. Returning Q2");
                    return questionaireRepository.findOne(2L);
                } else {
                    logger.info("/questionaire: User " + user.getUsername() +
                            " requested a questionaire, but is still waiting since last questionaire round");
                    return null;
                }
            } else if (lastAnswer.getQuestionaireId() == 2L) {
                logger.info("/questionaire: User " + user.getUsername() +
                        " is past first week. Returning Q3");
                return questionaireRepository.findOne(3L);
            } else if (lastAnswer.getQuestionaireId() == 3L) {
                logger.info("/questionaire: User " + user.getUsername() +
                        " is past first week. Returning Q6");
                return questionaireRepository.findOne(6L);
            } else {
                // this should never happen
                logger.error("Something went wrong in questionaire calculation for user " + user.getUsername()
                        + ". This should never happen.");
                return null;
            }
        }

        // this should never happen
        logger.error("Something went wrong in questionaire calculation for user " + user.getUsername()
                + ". This should never happen.");
        return null;
    }

    /**
     * Check if at least 7 days passed since the last questionaire.
     *
     * Add 7 days to the past day and see if its still earlier than now -> at least 7 days have passed.
     */
    static boolean timePassed(Timestamp timestamp) {
        LocalDateTime pastDateConverted = timestamp.toLocalDateTime();
        LocalDateTime pastDatePlusSeven = pastDateConverted.plusDays(7L);
        LocalDateTime now = LocalDateTime.now();
        return pastDatePlusSeven.isBefore(now);
    }
}
