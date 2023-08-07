package lesson04.hw;

import java.util.ArrayDeque;

public class Printer03 {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}

//    calculate('+', 3, 7) // 10
//    calculate('+', 4, 7) // 11
//    calculate('<', 0, 0) // 10

//    calculate('*', 3, 2) // 6
//    calculate('-', 7, 4) // 3
//    calculate('<', 0, 0) // 6
class Calculator {
    private ArrayDeque<Integer> results;

    public Calculator() {
        results = new ArrayDeque<>();
    }

    public int calculate(char op, int a, int b) {
        //Отмена последней операции должна быть реализована следующим образом: если передан оператор '<' калькулятор должен вывести результат предпоследней операции.

        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                results.push(result);
                break;
            case '-':
                result = a - b;
                results.push(result);
                break;
            case '*':
                result = a * b;
                results.push(result);
                break;
            case '/':
                result = a / b;
                results.push(result);
                break;
            case '<':
                if (results.size() > 1) {
                    results.pop();
                    result = results.peek();
                } else {
                    System.out.println("Некорректный оператор: '" + op + "'");
                }
                break;
            default:
                System.out.println("Некорректный оператор: '" + op + "'");
        }
        return result;
    }
}