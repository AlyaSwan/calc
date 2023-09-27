// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите арифметическое выражение, например, 1 + 2):");
            String input = scanner.nextLine();

            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                break;
            }
        }
    }


    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неправильный формат ввода");
        }

        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
             if(a<1 || a>10 || b<1 || b>10){
                 throw new Exception("Введите числа от 1 до 10");
             }
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть целыми числами");
        }


        char operator = parts[1].charAt(0);
        int result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Недопустимая операция:" + operator);
        }

        return Integer.toString(result);
    }
}












