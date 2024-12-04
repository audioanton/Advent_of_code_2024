package day_4.part_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XmasFinderTest {
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

    XmasFinder xmasFinder = new XmasFinder(testList);

    @Test
    void getSumXmasDiagonalBothDirections() {
        assertEquals(9, xmasFinder.getSumXmasDiagonalBothDirections());
    }
}