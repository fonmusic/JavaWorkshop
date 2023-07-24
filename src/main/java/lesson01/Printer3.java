package lesson01;

public class Printer3 {
    public static void main(String[] args) {
        double a = 0;
        char op = ' ';
        double b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 10;
            op = '/';
            b = 3;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}

/**
 * Класс Calculator, который выполняет математические операции (+, -, *, /)
 * над двумя числами и возвращать результат. В классе должен быть метод calculate,
 * который принимает оператор и значения аргументов и возвращает результат вычислений.
 * При неверно переданном операторе, программа должна вывести сообщение об ошибке
 * "Некорректный оператор: 'оператор'".
 */
class Calculator {
    public int calculate(char op, int a, int b) {
        int result = 0;
        switch (op) {
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
                result = a / b;
                break;
            default:
                System.out.println("Некорректный оператор: '" + op + "'");
        }
        return result;
    }

    public double calculate(char op, double a, double b) {
        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
            case 'x':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                System.out.println("Некорректный оператор: '" + op + "'");
        }
        return result;
    }

}