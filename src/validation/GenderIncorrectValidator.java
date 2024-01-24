package validation;

import enums.Gender;

import java.util.Set;

/**
 * Валидатор для проверки соответствия кода пола.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class GenderIncorrectValidator implements Rule {

    @Override
    public boolean isValid(String data, Set<String> errorSet) {
        String description =
                "Значения определяющие пол, не соответствуют одному из значений - М - мужчина, Ж - женщина";
        if (Gender.findByCode(data) == null) {
            errorSet.add(description);
            return false;
        }
        return true;
    }
}
