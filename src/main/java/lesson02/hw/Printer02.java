package lesson02.hw;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Printer02 {
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    // arr = new int[]{9, 4, 8, 3, 1};
    // sort(arr)
    // При чтении лог-файла получим:
    // 2023-05-19 07:53 [4, 8, 3, 1, 9]
    // 2023-05-19 07:53 [4, 3, 1, 8, 9]
    // 2023-05-19 07:53 [3, 1, 4, 8, 9]
    // 2023-05-19 07:53 [1, 3, 4, 8, 9]
    // 2023-05-19 07:53 [1, 3, 4, 8, 9]
    public static void sort(int[] mas) {
        try {
            log = new File("log.txt");
            fileWriter = new FileWriter(log, true);
            fileWriter.write(new SimpleDateFormat("yyyy-MM-dd HH:mm ").format(new Date()));
            fileWriter.write(Arrays.toString(mas));
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int temp;
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = 0; j < mas.length - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
    }
}
