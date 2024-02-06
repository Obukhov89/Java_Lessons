import java.util.Scanner;

public class Main {
    public static String calc() {
        // Создаем новый объект класса Scanner, параметром передаем System.in - стандартный поток входных данных
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String string = scan.nextLine();
        String[] arr_expression = string.split(" ");

        if (arr_expression.length > 3) {
            System.out.println("Ошибка ввода!");
            throw new RuntimeException("Формат ввода не удвлетворяет условиям. Два операнда и один оператор (+, -, /, *).");
        } else if (arr_expression.length <= 2) {
            System.out.println("Ошибка ввода!");
            throw new RuntimeException("Выражение не является математическим.");
        }

        int result = 0;

        try {
        // объявление переменных для работы калькулятора
            String type_operation = arr_expression[1];
            int operand1 = Integer.parseInt(arr_expression[0]);
            int operand2 = Integer.parseInt(arr_expression[2]);
        // проверка правильности введеных пользователем чисел
            if ((operand1 < 0 || operand1 > 10) || (operand2 < 0 || operand2 > 10)){
                System.out.println("Ошибка ввода!:");
                throw new RuntimeException("Число должно быть больше нуля и меньше либо равно десяти.");
            }

            switch (type_operation){
                case "+":
                result = operand1 + operand2;
                break;

                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.println("Ошибка ввода!");
                    throw new RuntimeException("Неверный оператор, используйте только +, -, *, / " +
                            "Ваш знак - " + arr_expression[1]);
            }
        } catch (NumberFormatException e){
            System.out.println("Ошибка ввода!");
            throw new RuntimeException("Используйте только целые числа");
        }

        String answer = Integer.toString(result);
        System.out.println("Результат:");
        System.out.println(answer);
        return  answer;
    }

    public static void main(String[] args) {
        calc();
    }
}