package day_4.part_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        XmasFinder xmasFinder = new XmasFinder();

        String path = "src/main/java/day_4/puzzle_input.txt";

        try (Scanner scanner = new Scanner(new FileReader(path))) {
            List<String> stringList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }

            System.out.println(xmasFinder.getSumXmasFromStringList(stringList));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
