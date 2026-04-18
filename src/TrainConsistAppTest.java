import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainConsistApp.filterBogies(getSampleBogies(), 70);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = TrainConsistApp.filterBogies(getSampleBogies(), 70);
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainConsistApp.filterBogies(getSampleBogies(), 60);
        assertTrue(result.stream().noneMatch(b -> b.getCapacity() <= 60));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = TrainConsistApp.filterBogies(getSampleBogies(), 60);
        assertEquals(2, result.size()); // 72 and 70
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainConsistApp.filterBogies(getSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainConsistApp.filterBogies(getSampleBogies(), 10);
        assertEquals(getSampleBogies().size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainConsistApp.filterBogies(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        TrainConsistApp.filterBogies(original, 60);

        assertEquals(copy.size(), original.size());
    }
}