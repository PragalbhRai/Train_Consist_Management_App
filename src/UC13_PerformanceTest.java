public class UC13_PerformanceTest {
}
import org.junit.jupiter.api.Test;
import java.util.*;
        import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UC13_PerformanceTest {

    // Sample Bogie class (use your actual class if already created)
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering
    private List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    private List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    // Test 1: Loop Filtering
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("General", 50)
        );

        List<Bogie> result = filterUsingLoop(list);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).type);
    }

    // Test 2: Stream Filtering
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("General", 50)
        );

        List<Bogie> result = filterUsingStream(list);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).type);
    }

    // Test 3: Results Match
    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 65),
                new Bogie("General", 50)
        );

        List<Bogie> loopResult = filterUsingLoop(list);
        List<Bogie> streamResult = filterUsingStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    // Test 4: Execution Time
    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Sleeper", i));
        }

        long start = System.nanoTime();
        filterUsingLoop(list);
        long end = System.nanoTime();

        long time = end - start;

        assertTrue(time > 0);
    }

    // Test 5: Large Dataset
    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Sleeper", i));
        }

        List<Bogie> result = filterUsingStream(list);

        assertTrue(result.size() > 0);
    }
}