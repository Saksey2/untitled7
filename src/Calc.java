import java.util.Scanner;

public class Calc extends Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение \"a\"+\"b\", \"a\"-\"b\", \"a\"* x, \"a\"+" +
                "/ x где a и b - строки до 10 букв а x - число  от 1 до 10 включительно и нажмите Enter ");
        String string = scanner.nextLine();
        System.out.println(calc(string));
    }
}