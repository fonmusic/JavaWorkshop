package lesson01;

public class Printer2 {
    public static void main(String[] args) {

        Answer2 ans = new Answer2();
        ans.printPrimeNums();
    }
}

class Answer2 {
    /**
     * Вывести на экран все простые числа от 1 до 1000
     */
    public void printPrimeNums(){
        for (int i = 1; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * Проверяет, является ли число простым
     * @param num число для проверки
     * @return true, если число простое, иначе false
     */
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
