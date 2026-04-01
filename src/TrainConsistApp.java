import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

public class TrainConsistApp {

  static class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
      this.name = name;
      this.capacity = capacity;
    }
  }

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
    // UC7 → UC10 (same as before)
    // ================================
    List<Bogie> bogieList = new ArrayList<>();
    bogieList.add(new Bogie("Sleeper", 72));
    bogieList.add(new Bogie("AC Chair", 56));
    bogieList.add(new Bogie("First Class", 24));
    bogieList.add(new Bogie("Sleeper", 70));
    bogieList.add(new Bogie("AC Chair", 60));

    // ================================
    // UC11 - Regex Validation
    // ================================
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
    List<GoodsBogie> goodsList = new ArrayList<>();

    goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
    goodsList.add(new GoodsBogie("Rectangular", "Coal"));
    goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));

    boolean isSafe = goodsList.stream()
            .allMatch(g ->
                    !g.type.equalsIgnoreCase("Cylindrical") ||
                            g.cargo.equalsIgnoreCase("Petroleum")
            );

    System.out.println(isSafe ? "Train is SAFE ✅" : "Train is UNSAFE ❌");

    // ================================
    // UC13 - Performance Comparison
    // ================================
    System.out.println("\n======================================");
    System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
    System.out.println("======================================\n");

    // Large dataset for realistic benchmarking
    List<Bogie> largeList = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      largeList.add(new Bogie("Sleeper", 50 + (i % 50)));
    }

    // -------- LOOP APPROACH --------
    long loopStart = System.nanoTime();

    List<Bogie> loopFiltered = new ArrayList<>();
    for (Bogie b : largeList) {
      if (b.capacity > 60) {
        loopFiltered.add(b);
      }
    }

    long loopEnd = System.nanoTime();
    long loopTime = loopEnd - loopStart;

    // -------- STREAM APPROACH --------
    long streamStart = System.nanoTime();

    List<Bogie> streamFiltered = largeList.stream()
            .filter(b -> b.capacity > 60)
            .collect(Collectors.toList());

    long streamEnd = System.nanoTime();
    long streamTime = streamEnd - streamStart;

    // -------- OUTPUT --------
    System.out.println("Loop Execution Time (ns): " + loopTime);
    System.out.println("Stream Execution Time (ns): " + streamTime);

    System.out.println("\nResult Size Check:");
    System.out.println("Loop Result Size: " + loopFiltered.size());
    System.out.println("Stream Result Size: " + streamFiltered.size());

    System.out.println("\nUC13 performance benchmarking completed...");
  }
}