package day_2.part_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportCheckerTest {

    ReportChecker checker = new ReportChecker();

    String inputRow = "7 6 4 2 1";

    List<List<Integer>> allRowsAsInts = Arrays.asList(
            List.of(7, 6, 4, 2, 1),
            List.of(1, 2, 7, 8, 9),
            List.of(9, 7, 6, 2, 1),
            List.of(1, 3, 2, 4, 5),
            List.of(8, 6, 4, 4, 1),
            List.of(1, 3, 6, 7, 9));

    @Test
    void isIncreasingSafe() {
        assertTrue(checker.isIncreasingSafe(1, 2));
        assertTrue(checker.isIncreasingSafe(1, 3));
        assertTrue(checker.isIncreasingSafe(1, 4));
        assertFalse(checker.isIncreasingSafe(2, 1));
        assertFalse(checker.isIncreasingSafe(1, 5));
    }

    @Test
    void isDecreasingSafe() {
        assertTrue(checker.isDecreasingSafe(2, 1));
        assertTrue(checker.isDecreasingSafe(3, 1));
        assertTrue(checker.isDecreasingSafe(4, 1));
        assertFalse(checker.isDecreasingSafe(1, 2));
        assertFalse(checker.isDecreasingSafe(5, 1));
    }

    @Test
    void isRowSafe() {
        assertTrue(checker.isRowSafe(true, false));
        assertTrue(checker.isRowSafe(false, true));
        assertFalse(checker.isRowSafe(false, false));
        assertFalse(checker.isRowSafe(true, true));
    }

    @Test
    void checkRow() {
        assertTrue(checker.checkRow(allRowsAsInts.getFirst()));
        assertFalse(checker.checkRow(allRowsAsInts.get(1)));
        assertFalse(checker.checkRow(allRowsAsInts.get(2)));
        assertFalse(checker.checkRow(allRowsAsInts.get(3)));
        assertFalse(checker.checkRow(allRowsAsInts.get(4)));
        assertTrue(checker.checkRow(allRowsAsInts.getLast()));
    }

    @Test
    void createListPerRow() {
        List<Integer> test = checker.createListPerRow(inputRow);
        assertEquals(allRowsAsInts.getFirst(), test);
    }
}