package my.goldgshok.life_tree.infrastructure;

import lombok.experimental.UtilityClass;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@UtilityClass
public class LocaleProvider {

    public String getLang() {
        return getLocale().getISO3Language();
    }

    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

}
