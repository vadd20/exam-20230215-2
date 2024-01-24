package enums;

/**
 * Перечисление для возможных ошибок.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public enum Error {
    NAME_IS_MORE_HUNDRED_SYMBOLS("ФИО сотрудника длинее 100 символов"),
    GENDER_IS_INCORRECT("Значения определяющие пол, не соответствуют одному из значений - М - мужчина, Ж - женщина,"),
    SALARY_IS_NOT_INTEGER("Оклад - не целое число");

    final String description;

    Error(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
