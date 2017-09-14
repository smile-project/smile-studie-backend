package de.smile_studie.restcontroller;

import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireAnswerRepository;
import de.smile_studie.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * Created by mss on 30.08.17.
 */
@RestController
public class QuestionaireAnswerController {

    @Autowired
    public QuestionaireAnswerRepository questionaireAnswerRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public Iterable<QuestionaireAnswer> answer(@RequestParam(value = "answer", defaultValue = "nix") String answer,
                                               @RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        QuestionaireAnswer qa = new QuestionaireAnswer();
        qa.setValueAnswer(new Random().nextInt(100));
        questionaireAnswerRepository.save(qa);
        return questionaireAnswerRepository.findAll();
    }
}
