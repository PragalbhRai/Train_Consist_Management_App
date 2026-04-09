import java.util.*;

// ================================
// CUSTOM RUNTIME EXCEPTION
// ================================
class CargoSafetyException extends RuntimeException {
  public CargoSafetyException(String message) {
    super(message);
  }
}

public class TrainConsistApp {

  // ================================
  // GOODS BOGIE
  // ================================
  static class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type) {
      this.type = type;
    }

    // ================================
    // SAFE CARGO ASSIGNMENT METHOD
    // ================================
    void assignCargo(String cargo) {
      try {
        // BUSINESS RULE
        if (type.equalsIgnoreCase("Rectangular") &&
                cargo.equalsIgnoreCase("Petroleum")) {
          throw new CargoSafetyException(
                  "Unsafe Assignment: Rectangular bogie cannot carry Petroleum"
          );
        }

        // SAFE ASSIGNMENT
        this.cargo = cargo;
        System.out.println("Cargo Assigned Successfully: " + type + " -> " + cargo);

      } catch (CargoSafetyException e) {
        System.out.println("Error: " + e.getMessage());

      } finally {
        System.out.println("Assignment Attempt Completed for: " + type);
      }
    }
  }

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC15 - Safe Cargo Assignment");
    System.out.println("======================================\n");

    // TEST CASES

    GoodsBogie g1 = new GoodsBogie("Cylindrical");
    GoodsBogie g2 = new GoodsBogie("Rectangular");

    // ✅ SAFE CASE
    g1.assignCargo("Petroleum");

    System.out.println();

    // ❌ UNSAFE CASE
    g2.assignCargo("Petroleum");

    System.out.println();

    // ✅ ANOTHER SAFE CASE
    g2.assignCargo("Coal");

    System.out.println("\nUC15 execution completed...");
  }
}