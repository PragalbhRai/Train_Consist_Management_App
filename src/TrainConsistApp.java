import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("=======================================");
    System.out.println("UC19 - Binary Search for Bogie ID");
    System.out.println("=======================================\n");

    // Step 1: Create UNSORTED bogie IDs
    String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

    // Step 2: Sort the array (REQUIRED for Binary Search)
    Arrays.sort(bogieIds);

    System.out.println("Sorted Bogie IDs:");
    System.out.println(Arrays.toString(bogieIds));

    // Step 3: Search key
    String searchKey = "BG309";

    System.out.println("\nSearching for Bogie ID: " + searchKey);

    // Step 4: Binary Search Logic
    int low = 0;
    int high = bogieIds.length - 1;
    boolean found = false;

    while (low <= high) {

      int mid = (low + high) / 2;

      int comparison = searchKey.compareTo(bogieIds[mid]);

      if (comparison == 0) {
        found = true;
        break;
      }
      else if (comparison < 0) {
        high = mid - 1; // search left
      }
      else {
        low = mid + 1; // search right
      }
    }

    // Step 5: Result
    if (found) {
      System.out.println("Result: Bogie FOUND in train consist.");
    } else {
      System.out.println("Result: Bogie NOT FOUND.");
    }

    System.out.println("\nUC19 binary search completed...");
  }
}