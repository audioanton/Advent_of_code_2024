package day_3.part_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemoryDecorrupter decorrupter = new MemoryDecorrupter();

        try (Scanner scanner = new Scanner(new FileReader("src/main/java/day_3/puzzleinput_3.txt"))) {
            int result = 0;

            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line).append("\n");
            }

            List<String> matches = decorrupter.createStringListFromMatches(sb.toString());

            for (String match : matches) {
                result += decorrupter.multiplyString(match);
            }

            System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
