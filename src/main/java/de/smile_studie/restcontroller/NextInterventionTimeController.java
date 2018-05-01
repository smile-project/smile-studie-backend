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

        if (user.getInterventionGroup() == 3 && user.getState() == 1) {
            // our control group, waits one week from the last questionaire
            QuestionaireAnswer answer = questionaireAnswerRepository.lastQuestionaireIdForUser(user.getId());
            LocalDateTime lastQuestionaire = answer.getTimestamp().toLocalDateTime();

            //TODO control group wait time 7 days in prod
            //lastQuestionaire = lastQuestionaire.plusDays(7);
            //lastQuestionaire = lastQuestionaire.plusHours(1);
            //lastQuestionaire = lastQuestionaire.plusMinutes(30);
            lastQuestionaire = lastQuestionaire.plusMinutes(15);

            logger.info("User " + user.getUsername() + " asked for next intervention time " + lastQuestionaire.toString());
            return Timestamp.valueOf(lastQuestionaire);
        }

        InterventionAnswer lastAnswer = interventionAnswerRepository.lastInterventionPosted(user.getId());

        if (lastAnswer == null) {
            // no answer posted yet, immediately available, but we might be blocked by -1 group anyway
            LocalDateTime nextQuestionaireTime = LocalDateTime.now();
            // remove 10 minutes to avoid time synch problems of a few seconds for some systems
            nextQuestionaireTime = nextQuestionaireTime.minusMinutes(10);
            logger.info("User " + user.getUsername() + " asked for next intervention time " + nextQuestionaireTime.toString());
            return Timestamp.valueOf(nextQuestionaireTime);
        } else {
            // normal case: next day 17:00
            LocalDateTime answerPosted = lastAnswer.getSubmissionDate().toLocalDateTime();
            logger.debug("last answer posted: " + answerPosted.toString());

            // TODO next day calculation -> next day 17:00 in prod

            // first get between 16 and 17
            /*if (answerPosted.getHour() >= 17) {
                answerPosted = answerPosted.plusHours(24 - answerPosted.getHour() + 16);
            } else {
                answerPosted = answerPosted.plusHours(16 - answerPosted.getHour());
            }

            answerPosted = answerPosted.plusSeconds(60 - answerPosted.getSecond());
            answerPosted = answerPosted.plusMinutes(60 - answerPosted.getMinute());
            */

            //answerPosted = answerPosted.plusMinutes(10);
            //answerPosted = answerPosted.plusMinutes(5);
            answerPosted = answerPosted.plusMinutes(2);
            logger.info("User " + user.getUsername() + " asked for next intervention time " + answerPosted.toString());
            return Timestamp.valueOf(answerPosted);
        }
    }

}
