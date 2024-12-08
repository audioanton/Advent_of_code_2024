package day_7.part_2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class OperatorCalibratorTest {
    OperatorCalibrator calibrator = new OperatorCalibrator();

    @Test
    void allMethods() {
        String s = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20""";

        Scanner scanner = new Scanner(s);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            calibrator.calibrateOperators(line);
        }
    }

    @Test
    void calibrateOperators() {
        calibrator.sum = 0;
        calibrator.calibrateOperators("7290: 6 8 6 15");
        assertEquals(7290, calibrator.sum);
        calibrator.sum = 0;
        calibrator.calibrateOperators("156: 15 6");
        assertEquals(156, calibrator.sum);
        calibrator.sum = 0;
        calibrator.calibrateOperators("192: 17 8 14");
        assertEquals(192, calibrator.sum);
        calibrator.sum = 0;

    }

    @Test
    void isMatch() {
    }

    @Test
    void getTestAndOperands() {
    }

    @Test
    void iterateAllOperands() {
        String s = "7290: 6 8 6 15";
        Long[] b = {1L, 2L, 3L};
        Long[] a = {6L, 8L, 6L, 15L};
        List<Long> res = calibrator.iterateAllOperands(a);
        assertEquals(27, res.size());


    }

    @Test
    void calculateTwoOperands() {
    }

    @Test
    void iterateLayer() {


    }
}