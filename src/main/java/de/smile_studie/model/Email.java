package de.smile_studie.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mss on 26.10.17.
 */
@Entity
public class Email {

    @Id
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
