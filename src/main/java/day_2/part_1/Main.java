package day_2.part_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReportChecker checker = new ReportChecker();

        try (Scanner scanner = new Scanner(new FileReader("src/main/java/day_2/puzzleInput.txt"))) {
            int result = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<Integer> row = checker.createListPerRow(line);
                if (checker.checkRow(row))
                    result++;
            }

            System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
