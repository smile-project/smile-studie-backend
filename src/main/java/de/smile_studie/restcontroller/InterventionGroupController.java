package de.smile_studie.restcontroller;

import de.smile_studie.model.security.User;
import de.smile_studie.security.JwtTokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mss on 03.10.17.
 */
@RestController
public class InterventionGroupController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/interventionGroup", method = RequestMethod.GET)
    public int answer(@RequestHeader("authorization") String token){
        User user = jwtTokenUtil.getUserFromFullToken(token);
        logger.info("User " + user.getUsername() +" asked for group");
        return user.getInterventionGroup();
    }
}
