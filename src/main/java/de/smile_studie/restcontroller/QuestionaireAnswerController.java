package de.smile_studie.restcontroller;

import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.security.JwtTokenUtil;
import de.smile_studie.security.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserRepository userRepository;

    private Random random = new Random();

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public void answer(@RequestBody QuestionaireAnswer[] answers,
                       @RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        for (QuestionaireAnswer answer : answers) {
            answer.setUserId(user.getId());
            answer.setTimestamp(Timestamp.from(Instant.now()));
            questionaireAnswerRepository.save(answer);
        }

        logger.info("User " + user.getUsername() + " answered Q" + answers[0].getQuestionaireId());

        if (answers[0].getQuestionaireId() == 6 && user.getState() == 0) {
            logger.info("User " + user.getUsername() + " changed state to 1 -> past first questionaire week");
            int interventionGroup = this.getRandomInterventionGroup();
            logger.info("User " + user.getUsername() + " randomed interventiongroup: " + interventionGroup);
            user.setInterventionGroup(interventionGroup);
            user.setState(1);
            userRepository.save(user);
        } else if (answers[0].getQuestionaireId() == 6 && user.getInterventionGroup() == 3 && user.getState() == 1) {
            // we are a group 3 dude after the waiting week
            logger.info("User " + user.getUsername() + " changed state to 2 -> past control week");
            user.setState(2);
            userRepository.save(user);
        }
    }

    /**
     * Returns random int values between 1 and 3.
     */
    public int getRandomInterventionGroup() {
        return this.random.nextInt(3) + 1;
    }
}
