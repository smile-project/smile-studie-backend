package de.smile_studie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by mss on 30.08.17.
 */
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "page_seq")
    @SequenceGenerator(name = "page_seq", sequenceName = "page_seq")
    private long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    private String title;

    @Column(columnDefinition = "VARCHAR(500)")
    private String text;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PAGES_QUESTIONAIREOPTIONS",
            joinColumns = {@JoinColumn(name = "PAGES_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "QUESTIONAIREOPTIONS_ID", referencedColumnName = "ID")})
    private Set<QuestionaireOption> answers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<QuestionaireOption> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<QuestionaireOption> answers) {
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
