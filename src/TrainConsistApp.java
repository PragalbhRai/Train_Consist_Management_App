import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("=======================================");
    System.out.println("UC20 - Exception Handling During Search");
    System.out.println("=======================================\n");

    // Step 1: Create bogie array (TRY EMPTY FIRST to test exception)
    String[] bogieIds = {};  // <-- Empty case

    // String[] bogieIds = {"BG101", "BG205", "BG309"}; // <-- Uncomment to test valid case

    String searchKey = "BG205";

    try {
      // Step 2: VALIDATION (Fail-Fast)
      if (bogieIds.length == 0) {
        throw new IllegalStateException("No bogies available in train. Cannot perform search.");
      }

      // Step 3: Binary Search (reuse UC19 logic)
      Arrays.sort(bogieIds);

      int low = 0;
      int high = bogieIds.length - 1;
      boolean found = false;

      while (low <= high) {
        int mid = (low + high) / 2;
        int comparison = searchKey.compareTo(bogieIds[mid]);

        if (comparison == 0) {
          found = true;
          break;
        } else if (comparison < 0) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }

      // Step 4: Result
      if (found) {
        System.out.println("Result: Bogie FOUND.");
      } else {
        System.out.println("Result: Bogie NOT FOUND.");
      }

    } catch (IllegalStateException e) {
      // Step 5: Handle exception
      System.out.println("ERROR: " + e.getMessage());
    }

    System.out.println("\nUC20 execution completed...");
  }
}