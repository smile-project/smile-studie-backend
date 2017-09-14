package de.smile_studie.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class InterventionAnswer {

    @Id
    private long id;

    private long interventionGroupId;

    private long userId;

    private String answerText;

    private Time date;

    private Time duration;
}
