package validation;

import java.util.Set;

/**
 * Валидатор для проверки, является ли оклад целым числом.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class SalaryNotIntegerValidator implements Rule {
    @Override
    public boolean isValid(String data, Set<String> errorSet) {
        String description = "Оклад - не целое число";
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            errorSet.add(description);
            return false;
        }
    }
}
