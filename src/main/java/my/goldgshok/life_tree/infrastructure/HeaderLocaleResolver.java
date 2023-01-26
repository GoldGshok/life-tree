package my.goldgshok.life_tree.infrastructure;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class HeaderLocaleResolver implements LocaleResolver {

    public static final String X_USER_LANG = "X-User-Lang";

    private final Locale defaultLocale;
    private final List<Locale> supportedLocales;

    @Override
    public Locale resolveLocale(@NonNull HttpServletRequest request) {
        final var iso3FromLang = Optional.ofNullable(request.getHeader(X_USER_LANG))
                .map(String::trim)
                .orElse(null);

        final var valDefaultLocale = getDefaultLocale();
        if (valDefaultLocale != null && iso3FromLang == null) {
            return valDefaultLocale;
        }

        if (iso3FromLang == null || iso3FromLang.length() != 3) {
            return Optional.ofNullable(valDefaultLocale).orElseGet(Locale::getDefault);
        }

        final var valSupportedLocales = getSupportedLocales();
        final var supportedLocale = findSupportedLocale(iso3FromLang, valSupportedLocales);
        if (supportedLocale != null) {
            return supportedLocale;
        }

        return Optional.ofNullable(valDefaultLocale).orElseGet(Locale::getDefault);
    }


    @Override
    public void setLocale(@NonNull HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale) {
        throw new UnsupportedOperationException(
                "Cannot change HTTP header - use a different locale resolution strategy");
    }

    @Nullable
    private Locale findSupportedLocale(@NonNull String langIso3, @NonNull List<Locale> supportedLocales) {
        return supportedLocales.stream()
                .filter(locale -> locale.getISO3Language().equals(langIso3))
                .findFirst()
                .orElseGet(this::getDefaultLocale);
    }

}
