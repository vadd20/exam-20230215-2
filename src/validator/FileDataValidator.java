package validator;

import enums.Error;
import enums.Gender;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * todo vpodogov
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
            boolean isError = false;
            String[] data = stringLine.split(SEPARATOR);
            if (data[0].length() > 100) {
                isError = true;
                errors.add(Error.NAME_IS_MORE_HUNDRED_SYMBOLS.getDescription());
            }

            if (Gender.findByCode(data[1]) == null) {
                isError = true;
                errors.add(Error.GENDER_IS_INCORRECT.getDescription());
            }

            try {
                Integer.parseInt(data[2]);
            } catch (NumberFormatException e) {
                isError = true;
                errors.add(Error.SALARY_IS_NOT_INTEGER.getDescription());
            }

            if (!isError) {
                correctLines.add(stringLine);
            } else {
                printError(counter, errors);
            }

            counter++;
        }

        return correctLines;
    }

    private static void printError(Integer counter, Set<String> errors) {
        var sb = new StringBuilder();
        errors.forEach(e -> {
            sb.append(e).append("; ");
            sb.delete(sb.length() - 2, sb.length());

        });
        System.out.println(counter + ": " + sb);
    }
}
