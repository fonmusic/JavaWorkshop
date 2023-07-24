package lesson01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Printer4 {
    public static void main(String[] args) {
        String file = "";

        if (args.length == 0) {
            file = "input.txt";
        } else {
            file = args[0];
        }

        Equation eq = new Equation();
        String result = eq.getSolution(file);
        System.out.println(result);
    }
}

class Equation {
    public String getSolution(String str) {
        try (BufferedReader br = new BufferedReader(new FileReader(str))) {
            String equation = br.readLine();

            // Разделяем уравнение на левую и правую части
            String[] parts = equation.split("=");
            String left = parts[0].trim();
            String right = parts[1].trim();

            // Находим индексы вопросительных знаков в левой и правой части
            List<Integer> leftQuestionMarks = findQuestionMarks(left);
            List<Integer> rightQuestionMarks = findQuestionMarks(right);

            // Перебираем все возможные значения для вопросительных знаков
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    // Формируем выражение, подставляя значения для вопросительных знаков
                    String replacedLeft = replaceQuestionMarks(left, leftQuestionMarks, i);
                    String replacedRight = replaceQuestionMarks(right, rightQuestionMarks, j);

                    // Вычисляем результат
                    int leftValue = Integer.parseInt(replacedLeft);
                    int rightValue = Integer.parseInt(replacedRight);

                    // Если уравнение верно, возвращаем результат
                    if (leftValue + rightValue == Integer.parseInt(right)) {
                        return "Given the equation: " + equation + "\nResult: " + replacedLeft + " = " + replacedRight;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "No solution";
    }
    // Метод для поиска индексов вопросительных знаков в строке
    private static List<Integer> findQuestionMarks(String str) {
        List<Integer> questionMarks = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                questionMarks.add(i);
            }
        }
        return questionMarks;
    }

    // Метод для замены вопросительных знаков на заданное значение
    private static String replaceQuestionMarks(String str, List<Integer> questionMarks, int value) {
        StringBuilder result = new StringBuilder(str);
        for (int index : questionMarks) {
            result.replace(index, index + 1, Integer.toString(value).trim());
        }
        return result.toString();
    }
}
