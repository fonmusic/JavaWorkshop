package lesson05.hw;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class Task02 {
    public static void main(String[] args) {
        var worker1 = new Worker("Иван", "Иванов");
        var worker2 = new Worker("Светлана", "Петрова");
        var worker3 = new Worker("Кристина", "Белова");
        var worker4 = new Worker("Aнна", "Мусина");
        var worker5 = new Worker("Анна", "Крутова");
        var worker6 = new Worker("Иван", "Юрин");
        var worker7 = new Worker("Петр", "Лыков");
        var worker8 = new Worker("Павел", "Чернов");
        var worker9 = new Worker("Петр", "Черннышев");
        var worker10 = new Worker("Мария", "Федорова");
        var worker11 = new Worker("Марина", "Светлова");
        var worker12 = new Worker("Мария", "Савина");
        var worker13 = new Worker("Мария", "Рыкова");
        var worker14 = new Worker("Марина", "Лугова");
        var worker15 = new Worker("Анна", "Владимирова");
        var worker16 = new Worker("Иван", "Мечников");
        var worker17 = new Worker("Петр", "Петин");
        var worker18 = new Worker("Иван", "Ежов");

        var workers = new Worker[]{
                worker1, worker2, worker3, worker4, worker5, worker6,
                worker7, worker8, worker9, worker10, worker11, worker12,
                worker13, worker14, worker15, worker16, worker17, worker18};

        var map = Worker.getMapOfNameOccurrences(workers);

        System.out.println("By popularity:");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
class Worker {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public static Map<String, Integer> getMapOfNameOccurrences(Worker[] workers) {
        Map<String, Integer> map = new HashMap<>();
        for (Worker worker : workers) {
            if (map.containsKey(worker.getFirstName())) {
                map.put(worker.getFirstName(), map.get(worker.getFirstName()) + 1);
            } else {
                map.put(worker.getFirstName(), 1);
            }
        }
        return map;
    }
}
