package de.smile_studie.repository;

import de.smile_studie.model.Questionaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 03.09.17.
 */
@RepositoryRestResource(exported = false)
public interface QuestionaireRepository extends CrudRepository<Questionaire, Long> {
}
