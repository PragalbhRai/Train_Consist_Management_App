import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("=======================================");
    System.out.println("UC18 - Linear Search for Bogie ID");
    System.out.println("=======================================\n");

    // Step 1: Create array of bogie IDs
    String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    // Step 2: Search key
    String searchKey = "BG309";

    System.out.println("Bogie IDs in Train:");
    System.out.println(Arrays.toString(bogieIds));

    System.out.println("\nSearching for Bogie ID: " + searchKey);

    // Step 3: Linear Search Logic
    boolean found = false;

    for (String id : bogieIds) {
      if (id.equals(searchKey)) {
        found = true;
        break; // Early termination
      }
    }

    // Step 4: Display Result
    if (found) {
      System.out.println("Result: Bogie FOUND in train consist.");
    } else {
      System.out.println("Result: Bogie NOT FOUND.");
    }

    System.out.println("\nUC18 search operation completed...");
  }
}