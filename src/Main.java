
import java.io.IOException;
        import java.lang.Exception;

public class Main {
    public static String calc(String input) throws Exception {

        String[] operation = {"*", "/", "+", "-"};
        String[] separator = {"\\*", "/", "\\+", "-"};

        int operationValue = -1;
        for (int i = 0; i < operation.length; i++) {
            if (input.contains(operation[i])) {
                operationValue = i;
                break;
            }
        }

        if (operationValue == -1) // Проверка на операнд
            throw new ArrayIndexOutOfBoundsException("Введенное выражение не содержит операнда(+,-,*,/)");

        String sep = input.replace("\s", "");
        String result = sep.replace("\"", "");
        String[] stringLenght = result.split(separator[operationValue]);
        int index1 = stringLenght[0].length();
        if (index1 == 0 || index1 > 10)//Проверяет длинну первой строки и запрещает ввод отрицательных чисел
            throw new IOException("Длинна первого операнда менее 1 символа или более 10 символов!");
        int index2 = stringLenght[1].length();
        if (index2 == 0 || index2 > 10)// Проверяет длинну второй строки и запрещает ввод отрицательных чисел
            throw new IOException("Длинна второго операнда менее 1 символа или более 10 символов!");

        String[] data = input.split(separator[operationValue]);
        int quotes = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[0].contains("\"")) {
                quotes = i;
                break;
            }
        }
        if (quotes == -1) {
            throw new IOException("Отсутствует первый операнд или не проставлены кавычки!");
        }

        int countQuotes = -1;
        for (char element : input.toCharArray()) {
            if (element == '"') countQuotes++;
        }
        switch (operation[operationValue]) {
            case "+" -> {
                if (countQuotes < 3)
                    throw new IOException("Введенные строки обозначаются кавычками!");
            }
            case "-" -> {
                if (countQuotes < 3)
                    throw new IOException("Введенные строки обозначаются кавычками!");
            }
            case "*" -> {
                if (countQuotes < 1)
                    throw new IOException("Введенные строки обозначаются кавычками!");
            }
            default -> {
                if (countQuotes < 1)
                    throw new IOException("Введенные строки обозначаются ковычками!");
            }
        }
        if (countQuotes > 3) {
            throw new IOException("Слишком много кавычек!");
        }

        return switch (operation[operationValue]) {// Передаем в метод согласно операнду
            case "+" -> {
                yield Addition.addition(result);
            }
            case "-" -> {
                yield Substraction.substraction(result);
            }
            case "*" -> {
                yield Multyplication.multyply(result);
            }
            default -> {
                yield Degree.degree(result);
            }
        };
    }
}