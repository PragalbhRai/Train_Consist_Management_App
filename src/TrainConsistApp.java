import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC5 - Preserve Insertion Order of Bogies");
    System.out.println("======================================\n");

    // Create LinkedHashSet
    Set<String> trainFormation = new LinkedHashSet<>();

    // Add bogies
    trainFormation.add("Engine");
    trainFormation.add("Sleeper");
    trainFormation.add("Cargo");
    trainFormation.add("Guard");

    // Add duplicate
    trainFormation.add("Sleeper"); // duplicate (ignored)

    // Display formation
    System.out.println("Final Train Formation:");
    System.out.println(trainFormation);

    System.out.println("\nUC5 operations completed successfully...");
  }
}