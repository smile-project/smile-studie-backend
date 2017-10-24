package de.smile_studie.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

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

    @Column(columnDefinition = "VARCHAR(1000)")
    private String answerInput1;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String answerInput2;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String answerInput3;

    private Timestamp submissionDate;

    private long submissionDuration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAnswerInput1() {
        return answerInput1;
    }

    public void setAnswerInput1(String answerInput1) {
        this.answerInput1 = answerInput1;
    }

    public String getAnswerInput2() {
        return answerInput2;
    }

    public void setAnswerInput2(String answerInput2) {
        this.answerInput2 = answerInput2;
    }

    public String getAnswerInput3() {
        return answerInput3;
    }

    public void setAnswerInput3(String answerInput3) {
        this.answerInput3 = answerInput3;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public long getSubmissionDuration() {
        return submissionDuration;
    }

    public void setSubmissionDuration(long submissionDuration) {
        this.submissionDuration = submissionDuration;
    }
}
