package de.smile_studie.repository;

import de.smile_studie.model.InterventionAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 03.10.17.
 */
@RepositoryRestResource(exported = false)
public interface InterventionAnswerRepository extends CrudRepository<InterventionAnswer, Long> {
}
