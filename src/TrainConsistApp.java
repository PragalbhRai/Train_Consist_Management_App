import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
    System.out.println("======================================\n");

    // Create HashMap
    Map<String, Integer> bogieCapacity = new HashMap<>();

    // Insert data
    bogieCapacity.put("Sleeper", 72);
    bogieCapacity.put("AC Chair", 56);
    bogieCapacity.put("First Class", 24);
    bogieCapacity.put("Cargo", 120);

    // Display data
    System.out.println("Bogie Capacity Details:\n");

    for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

    System.out.println("\nUC6 bogie-capacity mapping completed...");
  }
}