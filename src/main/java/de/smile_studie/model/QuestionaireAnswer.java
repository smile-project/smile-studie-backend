package de.smile_studie.model;

import javax.persistence.*;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class QuestionaireAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionaire_answer_seq")
    @SequenceGenerator(name = "questionaire_answer_seq", sequenceName = "questionaire_answer_seq")
    private long id;

    private long questionaireId;

    private long pageId;

    private int valueAnswer;

    private String textAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getValueAnswer() {
        return valueAnswer;
    }

    public void setValueAnswer(int valueAnswer) {
        this.valueAnswer = valueAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }
}
