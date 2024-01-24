package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import entity.Employee;

/**
 * Запись результата в файл.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class Writer {

    private static final String RESULT_FILENAME = "src\\result.txt";

    private static final String SEPARATOR = ";";

    public static void write(List<Employee> employees) throws IOException {
        try (var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESULT_FILENAME)))) {
            for (Employee employee : employees) {
                var sb = new StringBuilder()
                    .append(employee.name()).append(SEPARATOR)
                    .append(employee.gender().getDescription()).append(SEPARATOR)
                    .append(employee.salary());
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }
}
