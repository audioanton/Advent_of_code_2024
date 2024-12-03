package day_3.part_1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryDecorrupterTest {
    MemoryDecorrupter decorrupter = new MemoryDecorrupter();

    String nonMatches = "%&mul[3,7]!@^do_not_+mul(32,64]then";
    String test = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

    @Test
    void createStringListFromMatches() {
        List<String> result = decorrupter.createStringListFromMatches(test);
        List<String> emptyResult = decorrupter.createStringListFromMatches(nonMatches);

        assertNotNull(result);
        assertEquals(0, emptyResult.size());
        assertEquals("mul(2,4)", result.getFirst());
        assertEquals("mul(8,5)", result.getLast());
        assertEquals(4, result.size());
    }

    @Test
    void multiplyString() {
        assertEquals(8, decorrupter.multiplyString("mul(2,4)"));
        assertEquals(4000, decorrupter.multiplyString("mul(010,400)"));
        assertEquals(10100, decorrupter.multiplyString("mul(100,101)"));
    }
}