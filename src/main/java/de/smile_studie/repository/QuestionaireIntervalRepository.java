package de.smile_studie.repository;

import de.smile_studie.model.QuestionaireInterval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 28.09.17.
 */
@RepositoryRestResource(exported = false)
public interface QuestionaireIntervalRepository extends CrudRepository<QuestionaireInterval, Long> {

    @Query(value = "SELECT * FROM questionaire_interval WHERE current_questionaire_id = :lastAnswered AND user_state = :userState", nativeQuery = true)
    QuestionaireInterval nextQuestionaireIdForUser(@Param("lastAnswered") long lastAnswered, @Param("userState") int userState);
}
