package day_1.part_2;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntegerComparatorTwo integerComparator = new IntegerComparatorTwo();

        try (Scanner scanner = new Scanner(new FileReader("src/main/java/day_1/input_to_sort.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
            integerComparator.getSumOfDifferenceInString(stringBuilder.toString());

            System.out.println(integerComparator.calculateLikenessScore());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
