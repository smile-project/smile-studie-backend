package de.smile_studie.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class Questionaire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionaire_seq")
    @SequenceGenerator(name = "questionaire_seq", sequenceName = "questionaire_seq")
    private long id;

    @NotNull
    private String title;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "QUESTIONAIRE_PAGES",
            joinColumns = {@JoinColumn(name = "QUESTIONAIRE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PAGES_ID", referencedColumnName = "ID")})
    private Set<Page> pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
