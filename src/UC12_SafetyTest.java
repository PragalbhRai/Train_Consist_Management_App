import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UC12_SafetyTest {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Common validation logic (same as UC12)
    private boolean isSafe(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                b.type.equals("Cylindrical")
                        ? b.cargo.equals("Petroleum")
                        : true
        );
    }

    // 1️⃣ All valid
    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    // 2️⃣ Cylindrical invalid
    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal") // ❌ invalid
        );

        assertFalse(isSafe(list));
    }

    // 3️⃣ Non-cylindrical allowed
    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    // 4️⃣ Mixed with violation
    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // ❌ one violation
        );

        assertFalse(isSafe(list));
    }

    // 5️⃣ Empty list
    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(isSafe(list)); // important concept
    }
}