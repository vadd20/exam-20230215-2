package validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Валидатор данных, полученных из файла.
 *
 * @author Vadim Podogov
 * @since 2024.01.24
 */
public class FileDataValidator {

    private static final String SEPARATOR = ";";

    public static List<String> validate(Stream<String> lines) {
        var errors = new HashSet<String>();
        List<String> stringLines = lines.toList();
        var correctLines = new ArrayList<String>();

        Integer counter = 1;
        for (String stringLine : stringLines) {
            String[] data = stringLine.split(SEPARATOR);

            List<Boolean> ruleIsValidResults = List.of(new NameMoreHundredSymbolsValidator().isValid(data[0], errors),
                    new GenderIncorrectValidator().isValid(data[1], errors),
                    new SalaryNotIntegerValidator().isValid(data[2], errors));

            if (ruleIsValidResults.contains(false)) {
                printError(counter, errors);
            } else {
                correctLines.add(stringLine);
            }

            counter++;
        }

        return correctLines;
    }

    private static void printError(Integer counter, Set<String> errors) {
        var sb = new StringBuilder();
        errors.forEach(e -> {
            sb.append(e).append("; ");
        });
        sb.delete(sb.length() - 3, sb.length() - 1);
        System.out.println(counter + ": " + sb);
    }
}
