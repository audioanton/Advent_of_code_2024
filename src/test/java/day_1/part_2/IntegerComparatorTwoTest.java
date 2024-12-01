package day_1.part_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerComparatorTwoTest {
    IntegerComparatorTwo ic = new IntegerComparatorTwo();
    int expectedResult = 31;
    String fullInput =
            "3   4\n" +
            "4   3\n" +
            "2   5\n" +
            "1   3\n" +
            "3   9\n" +
            "3   3";

    @Test
    void getSumOcurrencesInListTest() {
        ic.getSumOfDifferenceInString(fullInput);
        int res = ic.getSumOcurrences(3);
        assertNotEquals(0, res);
        assertEquals(3, res);
    }

    @Test
    void calculateLikenessScoreTest() {
        ic.getSumOfDifferenceInString(fullInput);
        int res = ic.calculateLikenessScore();
        assertNotEquals(0, res);
        assertEquals(expectedResult, res);
    }
}