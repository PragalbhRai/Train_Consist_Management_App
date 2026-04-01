import java.util.*;

public class TrainConsistApp {

  // Bogie class
  static class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
      this.name = name;
      this.capacity = capacity;
    }
  }

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC7 - Sort Bogies by Capacity");
    System.out.println("======================================\n");

    // Create List
    List<Bogie> bogieList = new ArrayList<>();

    // Add passenger bogies
    bogieList.add(new Bogie("Sleeper", 72));
    bogieList.add(new Bogie("AC Chair", 56));
    bogieList.add(new Bogie("First Class", 24));

    // Sort bogies (ascending capacity)
    bogieList.sort(Comparator.comparingInt(b -> b.capacity));

    // Display sorted bogies
    System.out.println("Sorted Bogies by Capacity:\n");
    for (Bogie b : bogieList) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    System.out.println("\nUC7 sorting completed...");

    // ================================
    // UC8 - Stream Filtering
    // ================================

    System.out.println("\n======================================");
    System.out.println("UC8 - Filter Bogies using Streams");
    System.out.println("======================================\n");

    // Filter bogies with capacity > 60
    List<Bogie> filteredBogies = bogieList
            .stream()
            .filter(b -> b.capacity > 60)
            .toList(); // Use collect(Collectors.toList()) if Java < 16

    // Display filtered bogies
    System.out.println("Filtered Bogies (Capacity > 60):\n");
    for (Bogie b : filteredBogies) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    System.out.println("\nUC8 filtering completed...");
  }
}