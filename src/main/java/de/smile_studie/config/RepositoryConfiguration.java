package de.smile_studie.config;

import de.smile_studie.model.Page;
import de.smile_studie.model.Questionaire;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by mss on 02.09.17.
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        //config.exposeIdsFor(Questionaire.class);
        //config.exposeIdsFor(Page.class);
    }
}
