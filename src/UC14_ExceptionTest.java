import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC14_ExceptionTest {

    // ✅ Test 1: Valid capacity
    @Test
    void testException_ValidCapacityCreation() throws Exception {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getType());
        assertEquals(72, bogie.getCapacity());
    }

    // ❌ Test 2: Negative capacity
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ❌ Test 3: Zero capacity
    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("General", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ✅ Test 4: Exception message validation
    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -5);
        });

        assertTrue(exception.getMessage().contains("greater than zero"));
    }

    // ✅ Test 5: Object integrity
    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        PassengerBogie bogie = new PassengerBogie("First Class", 50);

        assertEquals("First Class", bogie.getType());
        assertEquals(50, bogie.getCapacity());
    }

    // ✅ Test 6: Multiple valid bogies
    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 60);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}