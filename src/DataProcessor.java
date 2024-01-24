import entity.Employee;
import enums.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для обработки считанных данных.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class DataProcessor {
    public List<Employee> process(List<Employee> employees) {
        Double averageMaleSalary = employees.stream()
            .filter(e -> e.gender() == Gender.MALE)
            .mapToInt(Employee::salary)
            .average()
            .orElse(0);

        return employees.stream()
            .filter(e -> e.salary() > averageMaleSalary)
            .sorted(Comparator.comparing(Employee::salary).reversed())
            .collect(Collectors.toList());
    }
}
