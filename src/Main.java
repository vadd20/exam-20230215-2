import java.io.IOException;
import java.util.List;
import entity.Employee;
import io.DataLoader;
import io.Writer;

/**
 * Основной класс.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class Main {
    public static void main(String[] args) throws IOException {

        List<Employee> employees = DataLoader.readEmployeeData();

        var processor = new DataProcessor();
        List<Employee> result = processor.process(employees);

        Writer.write(result);
    }
}