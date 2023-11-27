package my.goldgshok.life_tree.inftrastructure;

import my.goldgshok.life_tree.infrastructure.LocaleProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.stream.Stream;

class LocaleProviderTest {

    @ParameterizedTest
    @MethodSource("getLocales")
    void getLangTest(String expectedLang, String locale, String country) {
        LocaleContextHolder.setLocale(new Locale(locale, country));
        String actualLang = LocaleProvider.getLang();
        Assertions.assertEquals(expectedLang, actualLang);
        LocaleContextHolder.setLocale(new Locale("ru", "RU"));
    }

    private static Stream<Arguments> getLocales() {
        return Stream.of(Arguments.of("rus", "ru", "RU"),
                Arguments.of("eng", "en", "US"),
                Arguments.of("zho", "zh", "CN"),
                Arguments.of("tur", "tr", "TR"));
    }

}