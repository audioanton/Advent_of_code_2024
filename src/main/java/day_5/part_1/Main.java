package day_5.part_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UpdateValidator updateValidator = new UpdateValidator();

        try (Scanner scanner = new Scanner(new FileReader("src/main/java/day_5/puzzleInput.txt"))) {
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }

            List<String> rules = updateValidator.getListOfAllRules(sb.toString());
            List<List<String>> updates = updateValidator.getListOfAllUpdates(sb.toString());

            System.out.println(updateValidator.getSumAllValidUpdates(updates, rules));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
