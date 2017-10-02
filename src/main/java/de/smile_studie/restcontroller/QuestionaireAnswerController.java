package de.smile_studie.restcontroller;

import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.security.JwtTokenUtil;
import de.smile_studie.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by mss on 30.08.17.
 */
@RestController
public class QuestionaireAnswerController {

    @Autowired
    public QuestionaireAnswerRepository questionaireAnswerRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserRepository userRepository;

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public void answer(@RequestBody QuestionaireAnswer[] answers,
                       @RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        for (QuestionaireAnswer answer : answers) {
            answer.setUserId(user.getId());
            answer.setTimestamp(Timestamp.from(Instant.now()));
            questionaireAnswerRepository.save(answer);
        }

        if (answers[0].getQuestionaireId() == 6 && user.getState() == 0) {
            user.setState(1);
            userRepository.save(user);
        }
    }
}
