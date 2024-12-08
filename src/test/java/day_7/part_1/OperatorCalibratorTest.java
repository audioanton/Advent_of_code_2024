package day_7.part_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperatorCalibratorTest {
    OperatorCalibrator calibrator = new OperatorCalibrator();

    String correct = "292: 11 6 16 20";
    String correct_2 = "190: 10 19";
    String correct_3 = "3267: 81 40 27";
    String longTest = "553270827383: 9 682 588 53 8 2 9 4 8 5";
    String correctTest = "1530277084: 9 682 588 53 8 2 9 4 8 5";
    String correctTest2 = "191284691: 9 682 588 53 8 2 9 4 8 5";

    String[] incorrect = {
            "161011: 16 10 13",
            "83: 17 5",
            "156: 15 6",
            "7290: 6 8 6 15",
            "192: 17 8 14",
            "21037: 9 7 18 13"};

    @Test
    void calculateOperands() {
        Long[] test = calibrator.calculateTwoOperands(11, 6);

        assertEquals(17, test[0]);
        assertEquals(66, test[1]);
    }

    @Test
    void iterateAllOperands() {
        Long[] array = {81L, 40L, 27L};
        //List<Long> result = calibrator.iterateAllOperands(array);

        //assertEquals(4, result.size());
        //assertEquals(148, result.getFirst());
        //assertEquals(3267, result.get(1));
        //assertEquals(3267, result.get(2));
        //assertEquals(87480, result.get(3));

        Long[] a2 = {9L, 682L, 588L, 53L, 8L, 2L, 9L, 4L, 8L, 5L};
        List<Long> res = calibrator.iterateAllOperands(a2);

        assertEquals(1024, res.size());
    }

    @Test
    void iterateLayer() {
        List<Long> test = Arrays.asList(81L, 40L);
        String res = "148, 3267, 3267, 87480";
        Long[] array = {81L, 40L, 27L};

        List <Long> result = calibrator.iterateLayer(test, array, 1);

        assertEquals(121, result.getFirst());
        assertEquals(3240, result.getLast());

        List <Long> resulttwo = calibrator.iterateLayer(result, array, 2);

        assertEquals(4, resulttwo.size());
        assertEquals(148, resulttwo.getFirst());
        assertEquals(3267, resulttwo.get(1));
        assertEquals(3267, resulttwo.get(2));
        assertEquals(87480, resulttwo.get(3));
    }

    @Test
    void getTestAndOperands() {
        Long[] res = calibrator.getTestAndOperands(correct);
        assertEquals(4, res.length);
        assertEquals(11, res[0]);
        assertEquals(20, res[3]);
        assertEquals(292, calibrator.matcher);
    }

    @Test
    void isMatch() {
        calibrator.matcher = 123;
        List<Long> test1 = Arrays.asList(1L, 2L, 3L, 123L, 1L);
        List<Long> test2 = Arrays.asList(1L, 2L, 3L, 14L, 1L);

        assertTrue(calibrator.isMatch(test1));
        assertFalse(calibrator.isMatch(test2));
    }

    @Test
    void calibrateOperators() {
        calibrator.calibrateOperators(correct);
        assertEquals(292, calibrator.sum);
        calibrator.calibrateOperators(correct_2);
        assertEquals(482, calibrator.sum);
        calibrator.calibrateOperators(correct_3);
        assertEquals(3749, calibrator.sum);
        calibrator.calibrateOperators(incorrect[0]);
        calibrator.calibrateOperators(incorrect[1]);
        calibrator.calibrateOperators(incorrect[2]);
        calibrator.calibrateOperators(incorrect[3]);
        calibrator.calibrateOperators(incorrect[4]);
        assertEquals(3749, calibrator.sum);

        calibrator.sum = 0;
        calibrator.calibrateOperators(longTest);
        assertEquals(0, calibrator.sum);
        calibrator.calibrateOperators(correctTest);
        System.out.println(calibrator.matcher);
        assertEquals(1530277084, calibrator.sum);

    }
}