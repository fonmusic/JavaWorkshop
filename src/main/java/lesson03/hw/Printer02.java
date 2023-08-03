package lesson03.hw;

import java.util.Arrays;

public class Printer02 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer02 ans = new Answer02();
        ans.removeEvenNumbers(arr);
    }
}

class Answer02 {
    public static void removeEvenNumbers(Integer[] arr) {
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] %2 == 0) {
                count++;
            }
        }

        Integer[] newArr = new Integer[arr.length - count];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] %2 != 0) {
                newArr[j] = arr[i];
                j++;
            }
        }

        System.out.println("Новый массив: " + Arrays.toString(newArr));



    }
}