package de.smile_studie.restcontroller;

import de.smile_studie.model.Questionaire;
import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireAnswerRepository;
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

        // first week
        if (user.getState() == 0) {
            // we are not done with our first round of questionaires
            if (lastAnswer.getQuestionaireId() < 6L) {
                return questionaireRepository.findOne(lastAnswer.getQuestionaireId() + 1);
            }
        }

        // first week done
        if (user.getState() == 1) {
            // we are done with the first round, check if a week has passed
            if (lastAnswer.getQuestionaireId() == 6L) {
                if (timePassed(lastAnswer.getTimestamp())) {
                    return questionaireRepository.findOne(2L);
                } else {
                    return null;
                }
            } else if (lastAnswer.getQuestionaireId() == 2L) {
                return questionaireRepository.findOne(3L);
            } else if (lastAnswer.getQuestionaireId() == 3L) {
                return questionaireRepository.findOne(6L);
            } else {
                // this should never happen
                // TODO: 03.10.17 log error
                return null;
            }
        }

        // this should enver happen
        //TODO log error
        return null;
    }

    private boolean timePassed(Timestamp timestamp) {
        //TODO do this
        return false;
    }
}
