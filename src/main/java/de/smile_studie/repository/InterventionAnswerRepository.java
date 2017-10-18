package de.smile_studie.repository;

import de.smile_studie.model.InterventionAnswer;
import de.smile_studie.model.QuestionaireAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 03.10.17.
 */
@RepositoryRestResource(exported = false)
public interface InterventionAnswerRepository extends CrudRepository<InterventionAnswer, Long> {

    @Query(value = "SELECT * FROM intervention_answer WHERE user_id = :userId ORDER BY submission_date DESC LIMIT 1", nativeQuery = true)
    InterventionAnswer lastInterventionPosted(@Param("userId") long userId);

}
