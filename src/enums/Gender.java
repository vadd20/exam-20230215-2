package enums;

/**
 * Перечисления для возможных полов.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public enum Gender {
    MALE("М", "Мужчина"),
    FEMALE("Ж", "Женщина");

    final String code;
    final String description;
    Gender(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Gender findByCode(String code) {
        for (Gender value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }

    public String getDescription() {
        return this.description;
    }
}
