package de.smile_studie.restcontroller;

import de.smile_studie.model.InterventionAnswer;
import de.smile_studie.model.QuestionaireAnswer;
import de.smile_studie.model.security.User;
import de.smile_studie.repository.InterventionAnswerRepository;
import de.smile_studie.security.JwtTokenUtil;
import de.smile_studie.security.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by mss on 12.09.17.
 */
@RestController
public class InterventionAnswerController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public InterventionAnswerRepository interventionAnswerRepository;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/intervention", method = RequestMethod.POST)
    public void answer(@RequestBody InterventionAnswer answer,
                       @RequestHeader("authorization") String token) {
        User user = jwtTokenUtil.getUserFromFullToken(token);
        answer.setUserId(user.getId());
        answer.setSubmissionDate(Timestamp.from(Instant.now()));
        logger.info("User " + user.getUsername() + " submitted intervention");
        interventionAnswerRepository.save(answer);
    }

}
