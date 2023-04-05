package my.goldgshok.life_tree;

import my.goldgshok.life_tree.configuration.DataSourceTestConfiguration;
import my.goldgshok.life_tree.configuration.DatasourceConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

@Transactional
@Testcontainers
@ActiveProfiles("test")
@SpringBootTest(classes = {
        SpringBootBaseTest.TestApplication.class,
        DataSourceTestConfiguration.class
}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public abstract class SpringBootBaseTest {

    @EnableCaching
    @EnableAutoConfiguration(exclude = {
            DataSourceAutoConfiguration.class,
    })
    @ComponentScan(excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                    value = { Main.class, DatasourceConfiguration.class, }) })
    static class TestApplication {
    }

}
