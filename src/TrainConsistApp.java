import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("=== Train Consist Management App ===");
    System.out.println("======================================\n");

    // UC2 Header
    System.out.println("UC2 - Add Passenger Bogies to Train");
    System.out.println("======================================\n");

    // Create passenger bogie list
    List<String> passengerBogies = new ArrayList<>();

    // Add bogies
    passengerBogies.add("Sleeper");
    passengerBogies.add("AC Chair");
    passengerBogies.add("First Class");

    System.out.println("After Adding Bogies:");
    System.out.println("Passenger Bogies : " + passengerBogies);

    // Remove a bogie
    passengerBogies.remove("AC Chair");

    System.out.println("\nAfter Removing 'AC Chair':");
    System.out.println("Passenger Bogies : " + passengerBogies);

    // Check existence
    System.out.println("\nChecking if 'Sleeper' exists:");
    boolean exists = passengerBogies.contains("Sleeper");
    System.out.println("Contains Sleeper? : " + exists);

    // Final state
    System.out.println("\nFinal Train Passenger Consist:");
    System.out.println(passengerBogies);

    System.out.println("\nUC2 operations completed successfully...");
  }
}