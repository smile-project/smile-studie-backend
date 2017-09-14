package de.smile_studie.model;

import javax.persistence.*;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class QuestionaireResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionaire_response_seq")
    @SequenceGenerator(name = "questionaire_response_seq", sequenceName = "questionaire_response_seq")
    private long id;

    private long questionaireId;

    private long userId;

    private QuestionaireAnswer[] questionaireAnswers;

}
