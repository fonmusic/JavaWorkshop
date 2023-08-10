package lesson06.hw;

public class Main {
    public static void main(String[] args) {
        var laptops = new Laptop[10];
        laptops[0] = new Laptop(1, "Apple", "MacBook Pro", "macOS", 2000, 512, 16, 2, "silver");
        laptops[1] = new Laptop(2, "Apple", "MacBook Air", "macOS", 1500, 256, 8, 1, "silver");
        laptops[2] = new Laptop(3, "Microsoft", "Surface Laptop 3", "Windows", 1200, 256, 8, 1, "black");
        laptops[3] = new Laptop(4, "MSI", "GS66 Stealth", "Windows", 2000, 512, 16, 2, "black");
        laptops[4] = new Laptop(5, "Dell", "XPS 13", "Windows", 1500, 512, 16, 1, "silver");
        laptops[5] = new Laptop(6, "Toshiba", "Satellite Pro", "Windows", 800, 256, 8, 2, "black");
        laptops[6] = new Laptop(7, "HP", "Pavilion", "Windows", 1000, 512, 16, 2, "silver");
        laptops[7] = new Laptop(8, "Lenovo", "ThinkPad X1 Carbon", "Linux", 1500, 512, 16, 1, "black");
        laptops[8] = new Laptop(9, "MSI", "GS66 Stealth", "Windows", 2000, 512, 16, 2, "red");
        laptops[9] = new Laptop(10, "Apple", "MacBook Pro", "macOS", 2000, 512, 16, 2, "gray");

        System.out.println("Here are all the laptops in our database:");
        for (var laptop : laptops) {
            System.out.println(laptop);
        }

        LaptopFinder.printLaptopSearchFilters();
        var laptopFinder = new LaptopFinder(laptops);
        var filteredLaptops = laptopFinder.filterLaptops(laptops);

        System.out.println("Here are the laptops that match your search:");
        for (var laptop : filteredLaptops) {
            if (laptop != null) {
                System.out.println(laptop);
            }
        }
    }
}
