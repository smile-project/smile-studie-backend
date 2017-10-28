package de.smile_studie.restcontroller;

import de.smile_studie.model.Email;
import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.EmailRepository;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.security.JwtTokenUtil;
import de.smile_studie.security.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

/**
 * Created by mss on 30.08.17.
 */
@RestController
public class QuestionaireAnswerController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public QuestionaireAnswerRepository questionaireAnswerRepository;

    @Autowired
    public EmailRepository emailRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserRepository userRepository;

    private int randomGroup = 1;

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public void answer(@RequestBody QuestionaireAnswer[] answers,
                       @RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        for (QuestionaireAnswer answer : answers) {
            if (answer.getQuestionaireId() == 7 && answer.getPageId() == 702) {
                //value is our raffle email
                try {
                    Email studyFinishedEmail = new Email();
                    studyFinishedEmail.setEmail(answer.getTextAnswer());
                    emailRepository.save(studyFinishedEmail);
                } catch (Exception e) {
                    // empty email or duplicate key, so just ignore exception
                    logger.info("Something went wrong when saving email: " + answer.getTextAnswer());
                }
            } else {
                answer.setUserId(user.getId());
                answer.setTimestamp(Timestamp.from(Instant.now()));
                questionaireAnswerRepository.save(answer);
            }
        }

        logger.info("User " + user.getUsername() + " answered Q" + answers[0].getQuestionaireId());

        if (answers[0].getQuestionaireId() == 6 && user.getState() == 0) {
            // any user after the intial questionaires
            logger.info("User " + user.getUsername() + " changed state to 1 -> past initial questionaires");
            int interventionGroup = this.getRandomInterventionGroup();
            logger.info("User " + user.getUsername() + " randomed interventiongroup: " + interventionGroup);
            user.setInterventionGroup(interventionGroup);
            user.setState(1);
            userRepository.save(user);
        } else if (answers[0].getQuestionaireId() == 6 && user.getState() == 1) {
            logger.info("User " + user.getUsername() + " changed state to intermediate state 2 -> " +
                    "past first week before end questionaire");
            user.setState(2);
            userRepository.save(user);
        } else if (answers[0].getQuestionaireId() == 7 && user.getState() == 2) {
            // any user after the study end questionaire
            logger.info("User " + user.getUsername() + " changed state to 3 -> past first week");
            user.setState(3);
            userRepository.save(user);
        }
    }

    /**
     * The century old debate is over: Finally a TRUE SECURE RANDOM function.
     */
    private int getRandomInterventionGroup() {
        int currentGroup = this.randomGroup;
        this.randomGroup++;
        if (this.randomGroup == 4) {
            this.randomGroup = 1;
        }
        logger.info("Next group is now: " + this.randomGroup);
        return currentGroup;
    }
}
