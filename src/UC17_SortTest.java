import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC17_SortTest {

    // ✅ Test 1: Basic alphabetical sorting
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, BogieSorter.sortBogieNames(input));
    }

    // ✅ Test 2: Unsorted input
    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, BogieSorter.sortBogieNames(input));
    }

    // ✅ Test 3: Already sorted
    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, BogieSorter.sortBogieNames(input));
    }

    // ✅ Test 4: Duplicate values
    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, BogieSorter.sortBogieNames(input));
    }

    // ✅ Test 5: Single element
    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, BogieSorter.sortBogieNames(input));
    }
}