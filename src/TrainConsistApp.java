import java.util.*;

public class TrainConsistApp {

  // Bogie class (custom object)
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

    // Sort using Comparator (ascending order)
    bogieList.sort(Comparator.comparingInt(b -> b.capacity));

    // Display sorted bogies
    System.out.println("Sorted Bogies by Capacity:\n");

    for (Bogie b : bogieList) {
      System.out.println(b.name + " -> " + b.capacity);
    }

    System.out.println("\nUC7 sorting completed...");
  }
}