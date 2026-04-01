import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ================================
// CUSTOM EXCEPTION
// ================================
class InvalidCapacityException extends Exception {
  public InvalidCapacityException(String message) {
    super(message);
  }
}

public class TrainConsistApp {

  // ================================
  // PASSENGER BOGIE (WITH VALIDATION)
  // ================================
  static class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) throws InvalidCapacityException {
      if (capacity <= 0) {
        throw new InvalidCapacityException("Capacity must be greater than zero");
      }
      this.name = name;
      this.capacity = capacity;
    }
  }

  // ================================
  // GOODS BOGIE
  // ================================
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
    // UC14 - Exception Handling
    // ================================
    System.out.println("======================================");
    System.out.println("UC14 - Handle Invalid Bogie Capacity");
    System.out.println("======================================\n");

    List<Bogie> bogieList = new ArrayList<>();

    try {
      // Valid bogie
      Bogie b1 = new Bogie("Sleeper", 72);
      bogieList.add(b1);
      System.out.println("Created Bogie: " + b1.name + " -> " + b1.capacity);

      // Invalid bogie (TEST CASE)
      Bogie b2 = new Bogie("AC Chair", 0); // change to -10 also to test
      bogieList.add(b2);

    } catch (InvalidCapacityException e) {
      System.out.println("Error: " + e.getMessage());
    }

    System.out.println("\nUC14 exception handling completed...");
  }
}