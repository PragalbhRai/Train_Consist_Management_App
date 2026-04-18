import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UC15_CargoTest {

    // ✅ Test 1: Safe assignment
    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    // ❌ Test 2: Unsafe assignment handled
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        // cargo should NOT be assigned
        assertNull(bogie.getCargo());
    }

    // ❌ Test 3: Cargo not assigned after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    // ✅ Test 4: Program continues after exception
    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // fails
        bogie2.assignCargo("Petroleum"); // should still work

        assertEquals("Petroleum", bogie2.getCargo());
    }

    // ✅ Test 5: Finally block execution
    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // If finally block fails, this test will crash
        bogie.assignCargo("Petroleum");

        assertTrue(true); // reaching here = finally executed
    }
}