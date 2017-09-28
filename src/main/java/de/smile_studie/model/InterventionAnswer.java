package de.smile_studie.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class InterventionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intervention_answer_seq")
    @SequenceGenerator(name = "intervention_answer_seq", sequenceName = "intervention_answer_seq")
    private long id;

    private long userId;

    private String answerText;

    private Time date;

    private Time duration;
}
