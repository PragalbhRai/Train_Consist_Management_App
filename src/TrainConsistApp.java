public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC16 - Sort Passenger Bogies (Bubble Sort)");
    System.out.println("======================================\n");

    // INPUT ARRAY
    int[] capacities = {72, 56, 24, 70, 60};

    System.out.print("Before Sorting: ");
    printArray(capacities);

    // ================================
    // BUBBLE SORT LOGIC
    // ================================
    int n = capacities.length;

    for (int i = 0; i < n - 1; i++) {

      for (int j = 0; j < n - i - 1; j++) {

        // Compare adjacent elements
        if (capacities[j] > capacities[j + 1]) {

          // Swap
          int temp = capacities[j];
          capacities[j] = capacities[j + 1];
          capacities[j + 1] = temp;
        }
      }
    }

    System.out.print("\nAfter Sorting: ");
    printArray(capacities);

    System.out.println("\n\nUC16 bubble sort completed...");
  }

  // Helper Method
  public static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}