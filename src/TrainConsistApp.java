import java.util.Arrays;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC17 - Sort Bogie Names (Arrays.sort)");
    System.out.println("======================================\n");

    // INPUT ARRAY
    String[] bogieNames = {
            "Sleeper",
            "AC Chair",
            "First Class",
            "General",
            "Luxury"
    };

    System.out.println("Before Sorting:");
    System.out.println(Arrays.toString(bogieNames));

    // ================================
    // BUILT-IN SORT
    // ================================
    Arrays.sort(bogieNames);

    System.out.println("\nAfter Sorting:");
    System.out.println(Arrays.toString(bogieNames));

    System.out.println("\nUC17 sorting completed...");
  }
}