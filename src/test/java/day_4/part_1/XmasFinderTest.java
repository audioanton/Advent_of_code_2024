package day_4.part_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XmasFinderTest {
    XmasFinder xf = new XmasFinder();

    List<String> testList = Arrays.asList(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
    );

    int expected = 18;

    @Test
    void getSumXmasHorizontal() {
        String firstLine = testList.getFirst();
        String secondLine = testList.get(1);
        String thirdLine = testList.get(2);
        String fifthLine = testList.get(4);
        assertEquals(2, xf.getSumXmasHorizontal(fifthLine));
        assertEquals(1, xf.getSumXmasHorizontal(firstLine));
        assertEquals(1, xf.getSumXmasHorizontal(secondLine));
        assertEquals(0, xf.getSumXmasHorizontal(thirdLine));
    }

    @Test
    void getSumXmasVertical() {
        List<String> linesTwoToSeven = Arrays.asList(testList.get(1), testList.get(2), testList.get(3), testList.get(4), testList.get(5), testList.get(6));
        List<String> lineTwo = Arrays.asList(testList.getFirst());

        assertEquals(2, xf.getSumXmasVertical(linesTwoToSeven));
        assertEquals(0, xf.getSumXmasVertical(lineTwo));
    }

    @Test
    void getSumXmasDiagonalBothDirections() {
        assertEquals(5, xf.getSumXmasDiagonalRightDirection(testList));
    }

    @Test
    void getSumXmasDiagonalLeftDirection() {
        assertEquals(5, xf.getSumXmasDiagonalLeftDirection(testList));
    }

    @Test
    void getSumXmasFromStringList() {
        assertEquals(18, xf.getSumXmasFromStringList(testList));
    }

}