package day_7.part_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("src/main/java/day_7/puzzle_input.txt"))) {
            OperatorCalibrator calibrator = new OperatorCalibrator();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                calibrator.calibrateOperators(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
