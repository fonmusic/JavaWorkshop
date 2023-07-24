package lesson01;

public class Printer {
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 5;
        }
        else{
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangleNumber(n);
        System.out.println(itresume_res);
    }
}

class Answer {
    /**
     * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n).
     * @param n число, для которого вычисляется треугольное число
     * @return  треугольное число
     */
    public int countNTriangleNumber(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
}