package lesson05.hw;

import java.util.HashMap;
import java.util.Map;

public class Task01 {

    public static void main(String[] args) {
        var text = "Россия идет вперед всей планеты. Планета — это не Россия.";

        var map = getMapOfWordOccurrences(text);

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

    public static Map<String, Integer> getMapOfWordOccurrences(String text) {
        text = text.toLowerCase();
        String[] words = text.split("[^a-zа-я]+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (word.length() > 0) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        return map;
    }
}
