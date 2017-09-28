package de.smile_studie.repository;

import de.smile_studie.model.QuestionaireInterval;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 28.09.17.
 */
@RepositoryRestResource(exported = false)
public interface QuestionaireIntervalsRepository extends CrudRepository<QuestionaireInterval, Long> {
}
