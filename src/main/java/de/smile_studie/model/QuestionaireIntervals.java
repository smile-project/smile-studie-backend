package de.smile_studie.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class QuestionaireIntervals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionaire_intervals_seq")
    @SequenceGenerator(name = "questionaire_intervals_seq", sequenceName = "questionaire_intervals_seq")
    private long id;

    private long nextId;

    private Time timeInterval;
}
