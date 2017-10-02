package de.smile_studie.restcontroller;

import com.sun.xml.internal.bind.v2.TODO;
import de.smile_studie.model.Questionaire;
import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.QuestionaireInterval;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.repository.QuestionaireIntervalRepository;
import de.smile_studie.repository.QuestionaireRepository;
import de.smile_studie.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Created by mss on 03.09.17.
 */
@RestController
public class QuestionaireController {

    @Autowired
    public QuestionaireRepository questionaireRepository;

    @Autowired
    public QuestionaireIntervalRepository questionaireIntervalRepository;

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
            return questionaireRepository.findOne(1L);
        }

        QuestionaireInterval nextQuestionaireId = questionaireIntervalRepository.nextQuestionaireIdForUser(
                lastAnswer.getQuestionaireId(), user.getState());

        if (nextQuestionaireId.getTimeInterval().equals("P0S")) {
            // next questionaire at once
            return questionaireRepository.findOne(nextQuestionaireId.getNextQuestionaireId());
        } else if (nextQuestionaireId.getTimeInterval().equals("P7D")) {
            // check if 7 days have passed
            if (timePassed(lastAnswer.getTimestamp())) {
                return questionaireRepository.findOne(nextQuestionaireId.getNextQuestionaireId());
            }
        }

        return null;
    }

    private boolean timePassed(Timestamp timestamp) {
        //TODO do this
        return false;
    }
}
