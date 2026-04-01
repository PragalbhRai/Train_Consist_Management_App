import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

public class TrainConsistApp {

  // Passenger Bogie
  static class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
      this.name = name;
      this.capacity = capacity;
    }
  }

  // Goods Bogie
  static class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
      this.type = type;
      this.cargo = cargo;
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

    bogieList.forEach(b -> System.out.println(b.name + " -> " + b.capacity));

    // ================================
    // UC8 - Filtering
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC8 - Filter Bogies");
    System.out.println("======================================\n");

    List<Bogie> filtered = bogieList.stream()
            .filter(b -> b.capacity > 60)
            .toList();

    filtered.forEach(b -> System.out.println(b.name + " -> " + b.capacity));

    // ================================
    // UC9 - Grouping
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC9 - Group Bogies");
    System.out.println("======================================\n");

    bogieList.add(new Bogie("Sleeper", 70));
    bogieList.add(new Bogie("AC Chair", 60));

    Map<String, List<Bogie>> grouped = bogieList.stream()
            .collect(Collectors.groupingBy(b -> b.name));

    grouped.forEach((type, list) -> {
      System.out.println(type + ":");
      list.forEach(b -> System.out.println("  " + b.capacity));
    });

    // ================================
    // UC10 - Aggregation
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC10 - Total Capacity");
    System.out.println("======================================\n");

    int total = bogieList.stream()
            .map(b -> b.capacity)
            .reduce(0, Integer::sum);

    System.out.println("Total Capacity: " + total);

    // ================================
    // UC11 - Regex Validation
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC11 - Regex Validation");
    System.out.println("======================================\n");

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Train ID: ");
    String trainId = scanner.nextLine();

    System.out.print("Enter Cargo Code: ");
    String cargoCode = scanner.nextLine();

    Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
    Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

    boolean isTrainValid = trainPattern.matcher(trainId).matches();
    boolean isCargoValid = cargoPattern.matcher(cargoCode).matches();

    System.out.println(isTrainValid ? "Valid Train ID" : "Invalid Train ID");
    System.out.println(isCargoValid ? "Valid Cargo Code" : "Invalid Cargo Code");

    // ================================
    // UC12 - Safety Compliance
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC12 - Safety Compliance Check");
    System.out.println("======================================\n");

    List<GoodsBogie> goodsList = new ArrayList<>();

    // Sample Data (change for testing)
    goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
    goodsList.add(new GoodsBogie("Rectangular", "Coal"));
    goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
    // Try invalid case:
    // goodsList.add(new GoodsBogie("Cylindrical", "Coal"));

    System.out.println("Goods Bogies:");
    goodsList.forEach(g ->
            System.out.println(g.type + " -> " + g.cargo)
    );

    // SAFETY RULE USING STREAM
    boolean isSafe = goodsList.stream()
            .allMatch(g ->
                    !g.type.equalsIgnoreCase("Cylindrical") ||
                            g.cargo.equalsIgnoreCase("Petroleum")
            );

    System.out.println("\nSafety Status:");
    if (isSafe) {
      System.out.println("Train is SAFE ✅");
    } else {
      System.out.println("Train is UNSAFE ❌");
    }

    System.out.println("\nUC12 safety validation completed...");
  }
}