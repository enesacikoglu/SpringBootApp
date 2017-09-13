package sample.data.cassandra.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 *
 * @author bl4ckbird
 */
@Configuration
@EnableCassandraRepositories("sample.data.cassandra.repo")
public class CassandraConfig extends AbstractCassandraConfiguration{


	@Autowired
	ApplicationProperties properties;
	


    @Override
    protected String getKeyspaceName() {

        return properties.getKeyspaceName();
    }

    @Override
    protected String getContactPoints() {
        return properties.getContactPoints();
    }

    @Override
    protected int getPort() {
        return properties.getPort();
    }

         @Override
        public SchemaAction getSchemaAction() {
            return SchemaAction.NONE;
        }

    @Bean
    public CassandraOperations operations() throws Exception {

        return new CassandraTemplate(session().getObject(), new MappingCassandraConverter(new BasicCassandraMappingContext()));
    } 

}