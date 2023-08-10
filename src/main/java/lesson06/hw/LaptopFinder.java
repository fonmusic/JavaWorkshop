package lesson06.hw;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Data
@Getter
public class LaptopFinder {
    private Laptop[] laptops;
    private Map<Integer, String> userFilter;
    private static Map<Integer, String> laptopSearchFilters = Map.of(
            1, "Brand",
            2, "Model",
            3, "OS",
            4, "Price",
            5, "Storage",
            6, "RAM",
            7, "Weight",
            8, "Color"
    );

    public LaptopFinder(Laptop[] laptops) {
        this.laptops = laptops;
        this.userFilter = inputUserFilter();
    }

    public static void printLaptopSearchFilters() {
        System.out.println("Here are the filters you can use to search for a laptop:");
        laptopSearchFilters.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

    private static Map<Integer, String> inputUserFilter() {
        var scanner = new Scanner(System.in);
        System.out.print("How many filters do you want to use?: ");
        var numberOfFilters = Integer.parseInt(scanner.nextLine());
        Map<Integer, String> userFilter = new HashMap<>();
        for (int i = 0; i < numberOfFilters; i++) {
            System.out.print("Enter the number of the filter you want to use: ");
            var filterNumber = Integer.parseInt(scanner.nextLine());
            if (laptopSearchFilters.get(filterNumber).equals("Price")) {
                System.out.println("Enter the maximum price you want to search for: ");
            } else {
                System.out.print("Enter the " + laptopSearchFilters.get(filterNumber) + " you want to search for: ");
            }
            var filterValue = scanner.nextLine();
            userFilter.put(filterNumber, filterValue);
        }
        return userFilter;
    }

    public Laptop[] filterLaptops(Laptop[] laptops) {
        var filteredLaptops = new Laptop[laptops.length];
        var numberOfFilters = userFilter.size();

        for (int i = 0; i < laptops.length; i++) {
            var laptop = laptops[i];
            var numberOfMatches = 0;

            for (var filter : userFilter.entrySet()) {
                var filterNumber = filter.getKey();
                var filterValue = filter.getValue();

                if (matchesFilter(laptop, filterNumber, filterValue)) {
                    numberOfMatches++;
                }
            }
            if (numberOfMatches == numberOfFilters) {
                filteredLaptops[i] = laptop;
            }
        }
        return filteredLaptops;
    }

    private boolean matchesFilter(Laptop laptop, int filterNumber, String filterValue) {
        return switch (filterNumber) {
            case 1 -> laptop.getBrand().equalsIgnoreCase(filterValue);
            case 2 -> laptop.getModel().equalsIgnoreCase(filterValue);
            case 3 -> laptop.getOs().equalsIgnoreCase(filterValue);
            case 4 -> laptop.getPrice() <= Integer.parseInt(filterValue);
            case 5 -> laptop.getStorage() == Integer.parseInt(filterValue);
            case 6 -> laptop.getRam() == Integer.parseInt(filterValue);
            case 7 -> laptop.getWeight() == Integer.parseInt(filterValue);
            case 8 -> laptop.getColor().equalsIgnoreCase(filterValue);
            default -> {
                System.out.println("Invalid filter number");
                yield false;
            }
        };
    }
}
