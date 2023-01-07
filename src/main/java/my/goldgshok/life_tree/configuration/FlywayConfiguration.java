package my.goldgshok.life_tree.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .locations("classpath:/migration")
                .schemas("public")
                .mixed(true)
                .baselineOnMigrate(false)
                .dataSource(dataSource)
                .load();
    }

}
