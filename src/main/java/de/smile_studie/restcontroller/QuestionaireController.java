package de.smile_studie.restcontroller;

import de.smile_studie.model.Questionaire;
import de.smile_studie.model.QuestionaireInterval;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.QuestionaireIntervalsRepository;
import de.smile_studie.repository.QuestionaireRepository;
import de.smile_studie.security.JwtTokenUtil;
import org.postgresql.util.PGInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by mss on 03.09.17.
 */
@RestController
public class QuestionaireController {

    @Autowired
    public QuestionaireRepository questionaireRepository;

    @Autowired
    public QuestionaireIntervalsRepository questionaireIntervalsRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/questionaire", method = RequestMethod.GET)
    public QuestionaireInterval answer(@RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        Questionaire qa = questionaireRepository.findOne(1L);
        QuestionaireInterval questionaireInterval = questionaireIntervalsRepository.findOne(1L);
        return questionaireInterval;
        //return qa;
    }
}
