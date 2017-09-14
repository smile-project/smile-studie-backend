package de.smile_studie.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class InterventionGroup {

    @Id
    private long id;
    private String title;
    private String description;
}
