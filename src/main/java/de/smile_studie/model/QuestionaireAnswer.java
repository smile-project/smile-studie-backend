package de.smile_studie.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    private long answerId;

    private long userId;

    private int valueAnswer;

    @Column(columnDefinition = "VARCHAR(5000)")
    private String textAnswer;

    private Timestamp timestamp;

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


    public long getQuestionaireId() {
        return questionaireId;
    }

    public void setQuestionaireId(long questionaireId) {
        this.questionaireId = questionaireId;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
