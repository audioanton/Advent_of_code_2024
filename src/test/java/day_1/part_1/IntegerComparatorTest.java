package day_1.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class IntegerComparatorTest {
    IntegerComparator ic = new IntegerComparator();
    String fullInput =
            "3   4\n" +
            "4   3\n" +
            "2   5\n" +
            "1   3\n" +
            "3   9\n" +
            "3   3";

    String firstRow = "3   4";
    String secondRow = "4   3";

    @Test
    void getSumOfDifferenceInStringTest() {
        int result = ic.getSumOfDifferenceInString(fullInput);
        assertNotEquals(0, result);
        assertEquals(11, result);
    }

    @Test
    void separateIntPerColumnTest() {
        ic.separateIntPerColumn(firstRow);
        assertEquals(3, ic.leftColumnList.getFirst());
        assertEquals(4, ic.rightColumnList.getFirst());

        ic.separateIntPerColumn(secondRow);
        assertNotEquals(3, ic.leftColumnList.getLast());
        assertEquals(4, ic.leftColumnList.getLast());
        assertEquals(3, ic.rightColumnList.getLast());
    }

    @Test
    void compareTwoIntegersTest() {
        assertNotEquals(0, ic.compareTwoIntegers(1, 2));
        assertNotEquals(0, ic.compareTwoIntegers(2, 1));
        assertEquals(0, ic.compareTwoIntegers(3, 3));
        assertEquals(1, ic.compareTwoIntegers(4, 5));
        assertEquals(6, ic.compareTwoIntegers(3, 9));
        assertEquals(6, ic.compareTwoIntegers(9, 3));
    }
}