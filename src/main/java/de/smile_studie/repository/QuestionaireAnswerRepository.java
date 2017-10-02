package de.smile_studie.repository;

import de.smile_studie.model.QuestionaireAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 30.08.17.
 */
@RepositoryRestResource(exported = false)
public interface QuestionaireAnswerRepository extends CrudRepository<QuestionaireAnswer, Long> {

    @Query(value = "SELECT * FROM questionaire_answer WHERE user_id = :userId ORDER BY timestamp DESC LIMIT 1", nativeQuery = true)
    QuestionaireAnswer lastQuestionaireIdForUser(@Param("userId") long userId);
}
