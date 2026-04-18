import java.util.*;
import java.util.stream.Collectors;

class Bogie {
  String name;
  int capacity;

  public Bogie(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }
}

public class TrainConsistApp {

  // UC8 logic
  public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
    return bogies.stream()
            .filter(b -> b.getCapacity() > threshold)
            .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Bogie> bogies = new ArrayList<>();

    bogies.add(new Bogie("Sleeper", 72));
    bogies.add(new Bogie("AC Chair", 56));
    bogies.add(new Bogie("First Class", 24));
    bogies.add(new Bogie("Sleeper", 70));
    bogies.add(new Bogie("AC Chair", 60));

    List<Bogie> filtered = filterBogies(bogies, 60);

    System.out.println("Filtered Bogies:");
    for (Bogie b : filtered) {
      System.out.println(b.getName() + " -> " + b.getCapacity());
    }
  }
}