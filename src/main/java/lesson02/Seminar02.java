package lesson02;

public class Seminar02 {
    public static void main(String[] args) {
        var vector = new Vector(1, 2, 3);
        var vector2 = new Vector(1, 1, 1);
        System.out.println("vector = " + vector);
        System.out.println("vector2 = " + vector2);

        System.out.println("vector.length() = " + vector.length());
        System.out.println("vector2.length() = " + vector2.length());
        System.out.println("vector.scalarProduct(vector2) = " + vector.scalarProduct(vector2));
        System.out.println("vector.product(vector2) = " + vector.product(vector2));
        System.out.println("vector.getAngle(vector2) = " + vector.getAngle(vector2));

    }
}
