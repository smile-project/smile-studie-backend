package de.smile_studie.restcontroller;

import de.smile_studie.model.security.Authority;
import de.smile_studie.model.security.User;
import de.smile_studie.security.repository.AuthorityRepository;
import de.smile_studie.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by mss on 12.09.17.
 */
@RestController
public class RegistrationController {

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AuthorityRepository authorityRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        // just set authority to ROLE_USER, but we probably don't need it
        ArrayList<Authority> authorities = new ArrayList<>();
        Authority userAuthority = authorityRepository.findOne(1L);
        authorities.add(userAuthority);
        user.setAuthorities(authorities);
        user.setState(0);
        user.setInterventionGroup(-1);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
}
