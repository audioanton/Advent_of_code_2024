package day_2.part_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportCheckerTwoTest {
    ReportCheckerTwo checker = new ReportCheckerTwo();

    List<List<Integer>> allRowsAsInts = Arrays.asList(
            List.of(7, 6, 4, 2, 1),
            List.of(1, 2, 7, 8, 9),
            List.of(9, 7, 6, 2, 1),
            List.of(1, 3, 2, 4, 5),
            List.of(8, 6, 4, 4, 1),
            List.of(1, 3, 6, 7, 9));

    @Test
    void problemDampenerCheck() {
        assertFalse(checker.problemDampenerCheck(allRowsAsInts.get(1)));
        assertFalse(checker.problemDampenerCheck(allRowsAsInts.get(2)));
        assertTrue(checker.problemDampenerCheck(allRowsAsInts.get(3)));
        assertTrue(checker.problemDampenerCheck(allRowsAsInts.get(4)));
    }
}