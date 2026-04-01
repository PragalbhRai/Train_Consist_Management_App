import java.util.*;
import java.util.stream.Collectors;

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

    // ================================
    // UC7 - Sorting
    // ================================
    System.out.println("======================================");
    System.out.println("UC7 - Sort Bogies by Capacity");
    System.out.println("======================================\n");

    List<Bogie> bogieList = new ArrayList<>();

    bogieList.add(new Bogie("Sleeper", 72));
    bogieList.add(new Bogie("AC Chair", 56));
    bogieList.add(new Bogie("First Class", 24));

    bogieList.sort(Comparator.comparingInt(b -> b.capacity));

    System.out.println("Sorted Bogies by Capacity:\n");
    for (Bogie b : bogieList) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    System.out.println("\nUC7 sorting completed...");

    // ================================
    // UC8 - Filtering
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC8 - Filter Bogies using Streams");
    System.out.println("======================================\n");

    List<Bogie> filteredBogies = bogieList
            .stream()
            .filter(b -> b.capacity > 60)
            .toList();

    System.out.println("Filtered Bogies (Capacity > 60):\n");
    for (Bogie b : filteredBogies) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    System.out.println("\nUC8 filtering completed...");

    // ================================
    // UC9 - Grouping
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC9 - Group Bogies by Type");
    System.out.println("======================================\n");

    // Add more bogies for grouping
    bogieList.add(new Bogie("Sleeper", 70));

    System.out.println("All Bogies:");
    for (Bogie b : bogieList) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    Map<String, List<Bogie>> groupedBogies = bogieList
            .stream()
            .collect(Collectors.groupingBy(b -> b.name));

    System.out.println("\nGrouped Bogies:\n");

    for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {

      System.out.println("Bogie Type: " + entry.getKey());

      for (Bogie b : entry.getValue()) {
        System.out.println("    Capacity -> " + b.capacity);
      }

      System.out.println();
    }

    System.out.println("UC9 grouping completed...");

    // ================================
    // UC10 - Aggregation (reduce)
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC10 - Count Total Seats in Train");
    System.out.println("======================================\n");

    System.out.println("Bogies in Train:");
    for (Bogie b : bogieList) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    // Aggregate total capacity
    int totalCapacity = bogieList
            .stream()
            .map(b -> b.capacity)
            .reduce(0, Integer::sum);

    System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);

    System.out.println("\nUC10 aggregation completed...");
  }
}