package validation;

import java.util.Set;

/**
 * Валидатор для проверки количества символов в ФИО сотрудника.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class NameMoreHundredSymbolsValidator implements Rule {
    @Override
    public boolean isValid(String data, Set<String> errorSet) {
        String description = "ФИО сотрудника длинее 100 символов";
        if (data.length() > 100) {
            errorSet.add(description);
            return false;
        }
        return true;
    }
}
