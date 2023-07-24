package lesson01;

import java.util.Scanner;

public class Seminar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type array length: ");
        int n = scanner.nextInt();
        int[] ints = new int[n]; // todo : возможно и так - int[] ints = {1, 2, 3, 4};
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println("Is array symmetrical? " + isSymmetrical(ints));
        scanner.close();
    }

    /**
     * @apiNote условие задачи
     * @param nums массив интов
     * @return сообщение в виде String
     */
    private static boolean isSymmetrical(int[] nums) {
        boolean result = true;
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] != nums[nums.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }

}

