package lesson02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector {
    private double x;
    private double y;
    private double z;

    /**
     * Returns the length of the vector.
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Returns the scalar product of this vector and the specified vector.
     * @param vector2 the vector to compute the scalar product with
     * @return the scalar product of this vector and the specified vector
     */
    public double scalarProduct(Vector vector2) {
        return x * vector2.x + y * vector2.y + z * vector2.z;
    }

    /**
     * Returns the vector product of this vector and the specified vector.
     * @param vector2 the vector to compute the vector product with
     * @return the vector product of this vector and the specified vector
     */
    public Vector product(Vector vector2) {
        var x = this.y * vector2.z - this.z * vector2.y;
        var y = this.z * vector2.x - this.x * vector2.z;
        var z = this.x * vector2.y - this.y * vector2.x;
        return new Vector(x, y, z);
    }

    /**
     * Returns the angle between this vector and the specified vector.
     * @param vector2 the vector to compute the angle with
     * @return the angle between this vector and the specified vector
     */
    public double getAngle(Vector vector2) {
        var scalarProduct = scalarProduct(vector2);
        var length = length();
        var length2 = vector2.length();
        var cos = scalarProduct / (length * length2);
        var angle = Math.acos(cos);
        System.out.println("angle = " + angle);
        return angle;
    }
}
