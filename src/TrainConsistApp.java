import java.util.*;

public class TrainConsistApp {

  public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println("UC4 - Maintain Ordered Bogie Consist");
    System.out.println("======================================\n");

    // Create LinkedList
    LinkedList<String> train = new LinkedList<>();

    // Add initial bogies
    train.add("Engine");
    train.add("Sleeper");
    train.add("AC");
    train.add("Cargo");
    train.add("Guard");

    System.out.println("Initial Train Consist:");
    System.out.println(train);

    // Insert Pantry Car at position 2
    train.add(2, "Pantry Car");

    System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
    System.out.println(train);

    // Remove first and last bogie
    train.removeFirst();
    train.removeLast();

    System.out.println("\nAfter Removing First and Last Bogie:");
    System.out.println(train);

    System.out.println("\nUC4 ordered consist operations completed...");
  }
}