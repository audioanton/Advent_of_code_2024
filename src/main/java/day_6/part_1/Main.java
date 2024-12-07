package day_6.part_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatrolAnalyzer patrolAnalyzer = new PatrolAnalyzer();

        try (Scanner scanner = new Scanner(new FileReader("src/main/java/day_6/puzzle_input.txt"))) {
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
                builder.append("\n");
            }

            System.out.println(patrolAnalyzer.sumAllSteps(builder.toString()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
