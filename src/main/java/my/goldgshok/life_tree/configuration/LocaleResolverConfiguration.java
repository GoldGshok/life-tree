package my.goldgshok.life_tree.configuration;

import my.goldgshok.life_tree.infrastructure.HeaderLocaleResolver;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
@ConditionalOnClass(name = "org.springframework.web.servlet.LocaleResolver")
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@AutoConfigureBefore(name = "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration")
public class LocaleResolverConfiguration {

    @Bean
    LocaleResolver localeResolver(LocaleProperties localeProperties) {
        return new HeaderLocaleResolver(localeProperties.getDefaultLocale(), localeProperties.getSupportedLocales());
    }

}
