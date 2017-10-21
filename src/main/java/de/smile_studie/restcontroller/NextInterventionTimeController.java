package de.smile_studie.restcontroller;

import de.smile_studie.model.InterventionAnswer;
import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.InterventionAnswerRepository;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.security.JwtTokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by mss on 18.10.17.
 */
@RestController
public class NextInterventionTimeController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @Autowired
    public InterventionAnswerRepository interventionAnswerRepository;

    @Autowired
    public QuestionaireAnswerRepository questionaireAnswerRepository;

    @RequestMapping(value = "/nextIntervention", method = RequestMethod.GET)
    public Timestamp answer(@RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        logger.info("User " + user.getUsername() + " asked for last intervention time");

        if (user.getInterventionGroup() == 3 && user.getState() == 1) {
            // our control group, waits one week from the last questionaire
            QuestionaireAnswer answer = questionaireAnswerRepository.lastQuestionaireIdForUser(user.getId());
            LocalDateTime lastQuestionaire = answer.getTimestamp().toLocalDateTime();
            lastQuestionaire = lastQuestionaire.plusDays(7);
            return Timestamp.valueOf(lastQuestionaire);
        }

        InterventionAnswer lastAnswer = interventionAnswerRepository.lastInterventionPosted(user.getId());

        if (lastAnswer == null) {
            // no answer posted yet, immediately available, but we might be blocked by -1 group anyway
            return Timestamp.valueOf(LocalDateTime.now());
        } else {
            // normal case: next day 17:00
            LocalDateTime answerPosted = lastAnswer.getSubmissionDate().toLocalDateTime();
            logger.debug("last answer posted: " + answerPosted.toString());

            // first get between 16 and 17
            if (answerPosted.getHour() >= 17) {
                answerPosted = answerPosted.plusHours(24 - answerPosted.getHour() + 16);
            } else {
                answerPosted = answerPosted.plusHours(16 - answerPosted.getHour());
            }

            answerPosted = answerPosted.plusSeconds(60 - answerPosted.getSecond());
            answerPosted = answerPosted.plusMinutes(60 - answerPosted.getMinute());
            return Timestamp.valueOf(answerPosted);
        }
    }

}
