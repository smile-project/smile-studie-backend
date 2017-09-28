package de.smile_studie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class QuestionaireOption {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionaire_option_seq")
    @SequenceGenerator(name = "questionaire_option_seq", sequenceName = "questionaire_option_seq")
    private long id;

    @NotNull
    private int value;

    @NotNull
    private String type;

    private String text;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
