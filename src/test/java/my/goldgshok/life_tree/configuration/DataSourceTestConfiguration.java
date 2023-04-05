package my.goldgshok.life_tree.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@TestConfiguration
public class DataSourceTestConfiguration {

    @Bean(destroyMethod = "stop")
    public PostgreSQLContainer<?> postgreSqlContainer() {
        var postgreSQLContainer = new PostgreSQLContainer<>("postgres:15.1-alpine")
                .withDatabaseName("life_tree")
                .withExposedPorts(5432)
                .withUsername("user")
                .withPassword("123");
        postgreSQLContainer.start();
        return postgreSQLContainer;
    }

    @Primary
    @Bean(name = "dataSource", destroyMethod = "close")
    public DataSource dataSource(PostgreSQLContainer<?> postgreSqlContainer) {
        return DataSourceBuilder.create().type(HikariDataSource.class)
                .url(postgreSqlContainer.getJdbcUrl() + "&stringtype=unspecified")
                .username(postgreSqlContainer.getUsername())
                .password(postgreSqlContainer.getPassword())
                .driverClassName(postgreSqlContainer.getDriverClassName())
                .build();
    }

}
