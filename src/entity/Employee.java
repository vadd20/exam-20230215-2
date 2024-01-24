package entity;

import enums.Gender;

/**
 * Сущность сотрудника.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public record Employee(String name, Gender gender, Integer salary) {
}
