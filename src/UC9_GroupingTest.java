import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UC9_GroupingTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }
    }

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("Sleeper", 72),
                new Bogie("First Class", 40)
        );
    }

    // 1️⃣ Basic grouping
    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> grouped =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    // 2️⃣ Multiple in same group
    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> grouped =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, grouped.get("Sleeper").size());
    }

    // 3️⃣ Different types
    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> grouped =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    // 4️⃣ Empty list
    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        Map<String, List<Bogie>> grouped =
                empty.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.isEmpty());
    }

    // 5️⃣ Single category
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> grouped =
                list.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(1, grouped.size());
        assertEquals(2, grouped.get("Sleeper").size());
    }

    // 6️⃣ Keys validation
    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> grouped =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(grouped.keySet().contains("Sleeper"));
        assertTrue(grouped.keySet().contains("AC Chair"));
    }

    // 7️⃣ Group size validation
    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> grouped =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    // 8️⃣ Original list unchanged
    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();

        original.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(4, original.size()); // unchanged
    }
}