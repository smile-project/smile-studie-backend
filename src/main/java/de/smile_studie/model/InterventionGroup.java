package de.smile_studie.model;

import javax.persistence.*;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class InterventionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intervention_group_seq")
    @SequenceGenerator(name = "intervention_group_seq", sequenceName = "intervention_group_seq")
    private long id;

    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
