package lesson06.hw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Laptop {
    private int id;
    private String brand;
    private String model;
    private String os;
    private int price;
    private int storage;
    private int ram;
    private int weight;
    private String color;

    @Override
    public String toString() {
        return  "id - " + id +
                ", brand - " + brand +
                ", model - " + model +
                ", os - " + os +
                ", price - " + price +
                ", storage - " + storage +
                ", ram - " + ram +
                ", weight - " + weight +
                ", color - " + color;
    }
}
