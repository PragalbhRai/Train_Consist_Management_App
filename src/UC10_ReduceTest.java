import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UC10_ReduceTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );
    }

    // 1️⃣ Total seat calculation
    @Test
    void testReduce_TotalSeatCalculation() {
        int total = getSampleBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(172, total);
    }

    // 2️⃣ Multiple bogies
    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = getSampleBogies().stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(172, total);
    }

    // 3️⃣ Single bogie
    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72));

        int total = list.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    // 4️⃣ Empty list
    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        int total = empty.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    // 5️⃣ Correct extraction using map()
    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = getSampleBogies();

        List<Integer> capacities = list.stream()
                .map(Bogie::getCapacity)
                .toList();

        assertEquals(Arrays.asList(72, 60, 40), capacities);
    }

    // 6️⃣ All bogies included
    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = getSampleBogies();

        int total = list.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        int manualSum = 0;
        for (Bogie b : list) {
            manualSum += b.capacity;
        }

        assertEquals(manualSum, total);
    }

    // 7️⃣ Original list unchanged
    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = getSampleBogies();

        list.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(3, list.size());
    }
}