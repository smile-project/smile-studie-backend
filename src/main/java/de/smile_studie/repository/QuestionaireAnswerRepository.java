package de.smile_studie.repository;

import de.smile_studie.model.QuestionaireAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 30.08.17.
 */
@RepositoryRestResource(exported = false)
public interface QuestionaireAnswerRepository extends CrudRepository<QuestionaireAnswer, Long>{

}
