package de.smile_studie.model;

import org.postgresql.util.PGInterval;

import javax.persistence.*;
import java.sql.Time;
import java.time.Period;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class QuestionaireInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionaire_intervals_seq")
    @SequenceGenerator(name = "questionaire_intervals_seq", sequenceName = "questionaire_intervals_seq")
    private long id;

    private long currentQuestionaireId;

    private long nextQuestionaireId;

    private int userState;

    private String timeInterval;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCurrentQuestionaireId() {
        return currentQuestionaireId;
    }

    public void setCurrentQuestionaireId(long currentQuestionaireId) {
        this.currentQuestionaireId = currentQuestionaireId;
    }

    public long getNextQuestionaireId() {
        return nextQuestionaireId;
    }

    public void setNextQuestionaireId(long nextQuestionaireId) {
        this.nextQuestionaireId = nextQuestionaireId;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
