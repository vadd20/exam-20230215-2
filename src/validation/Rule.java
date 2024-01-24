package validation;

import java.util.Set;

/**
 * Интерфейс для правила.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public interface Rule {
    boolean isValid(String data, Set<String> errorSet);
}
