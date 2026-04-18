import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchExceptionTest {

    // Helper method (replace with your actual UC20 method)
    private boolean searchWithValidation(String[] bogies, String key) {

        if (bogies.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String b : bogies) {
            if (b.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            searchWithValidation(bogies, "BG101");
        });

        assertEquals("No bogies available for search", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};

        assertDoesNotThrow(() -> {
            searchWithValidation(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        assertTrue(searchWithValidation(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        assertFalse(searchWithValidation(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};

        assertTrue(searchWithValidation(bogies, "BG101"));
    }
}