package io;

import entity.Employee;
import enums.Gender;
import validator.FileDataValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Чтение данных из файла.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class DataLoader {

    private static final String EMPLOYEES_FILENAME = "src\\data\\employees.txt";

    private static final String SEPARATOR = ";";

    /**
     * Чтение сущностей сотрудников из файла.
     * 
     * @return список сущностей сотрудников
     * @throws IOException
     *             ошибка ввода/вывода
     */
    public static List<Employee> readEmployeeData() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(EMPLOYEES_FILENAME))) {
            List<String> correctLines = FileDataValidator.validate(lines);
            return correctLines.stream()
                    .map(line -> line.split(SEPARATOR))
                    .map(data -> new Employee(data[0], Gender.findByCode(data[1]), Integer.parseInt(data[2])))
                    .collect(Collectors.toList());
        }
    }

}
