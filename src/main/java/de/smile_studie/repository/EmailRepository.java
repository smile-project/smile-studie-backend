package de.smile_studie.repository;

import de.smile_studie.model.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mss on 26.10.17.
 */
@RepositoryRestResource(exported = false)
public interface EmailRepository extends CrudRepository<Email, Long>{
}
