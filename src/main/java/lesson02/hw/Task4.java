package lesson02.hw;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Calculator {
    /**
     * @apiNote Напишите класс Calculator, который будет выполнять математические операции (+, -, *, /) над двумя числами и возвращать результат. В классе должен быть метод calculate, который принимает оператор и значения аргументов и возвращает результат вычислений.
     *
     * При неверно переданном операторе, программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".
     * @param op математическиий оператор
     * @param a первый параметр
     * @param b второй параметр
     * @return результат вычисления
     */

    /**
     * @param mas массив
     * @apiNote Делает запись текущего состояния массива в лог файл
     */
    private static void writeToLog(String message) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = date.toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);

            fileWriter.append(dateTimeFormatter.format(localDateTime) + " " + message + "\n");
            fileWriter.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public int calculate(char op, int a, int b) {
        // Введите свое решение ниже

        int result = 0;
        if (op == '+')
            result = a + b;
        else if (op == '-')
            result = a - b;
        else if (op == '*')
            result = a * b;
        else if (op == '/')
            result = a / b;

        writeToLog("User entered the first operand = " + a);
        writeToLog("User entered the operation = " + op);
        writeToLog("User entered the second operand = " + b);
        writeToLog("Result is " + result);
        return result;
    }
}

public class Task4 {
    private static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        clearLogFile();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);

        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearLogFile() {
        File logFile = new File(LOG_FILE_PATH);
        if (logFile.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(logFile, false);
                fileWriter.write("");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}