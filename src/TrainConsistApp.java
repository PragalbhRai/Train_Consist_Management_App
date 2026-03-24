import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("=== Train Consist Management App ===");
    System.out.println("======================================\n");

    // UC3 Header
    System.out.println("UC3 - Track Unique Bogie IDs");
    System.out.println("======================================\n");

    // Create HashSet for unique bogie IDs
    Set<String> bogieIds = new HashSet<>();

    // Adding bogies (with duplicates intentionally)
    bogieIds.add("BG101");
    bogieIds.add("BG102");
    bogieIds.add("BG103");
    bogieIds.add("BG101"); // duplicate
    bogieIds.add("BG102"); // duplicate

    // Display result
    System.out.println("Bogie IDs after insertion:");
    System.out.println(bogieIds);

    System.out.println("\nNote: Duplicate IDs are automatically removed.");

    System.out.println("\nUC3 operations completed successfully...");
  }
}