package my.goldgshok.life_tree.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openApi() {
        var openApi = new OpenAPI();
        openApi.setInfo(getInfo());
        return openApi;
    }

    private Info getInfo() {
        var info = new Info();
        info.setTitle("Модуль древо жизни");
        return info;
    }

}
