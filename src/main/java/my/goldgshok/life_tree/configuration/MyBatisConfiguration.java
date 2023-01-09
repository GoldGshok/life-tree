package my.goldgshok.life_tree.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "my.goldgshok.life_tree.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisConfiguration {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        var sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/my/goldgshok/life_tree/dao/config.xml"));
        return sqlSessionFactoryBean;
    }

}
