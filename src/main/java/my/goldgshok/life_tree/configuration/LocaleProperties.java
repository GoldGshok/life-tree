package my.goldgshok.life_tree.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "locale.properties")
public class LocaleProperties {
    /**
     * Список поддерживаемых локализаций.
     */
    private List<Locale> supportedLocales;
    /**
     * Локализация по умолчанию. Используется, если заголовок X-User-Lang содержит неподдерживаемую локализацию.
     */
    private Locale defaultLocale = new Locale("ru", "RU");
}