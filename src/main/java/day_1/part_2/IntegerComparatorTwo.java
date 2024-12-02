package day_1.part_2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IntegerComparatorTwo {
    int result;
    List<Integer> leftColumnList;
    List<Integer> rightColumnList;

    public IntegerComparatorTwo() {
        result = 0;
        leftColumnList = new ArrayList<>();
        rightColumnList = new ArrayList<>();
    }

    public int getSumOfDifferenceInString(String s) {

        try (Scanner scanner = new Scanner(s)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                separateIntPerColumn(line);
            }

            Collections.sort(leftColumnList);
            Collections.sort(rightColumnList);

            for (int i = 0; i < leftColumnList.size(); i++) {
                result += compareTwoIntegers(leftColumnList.get(i), rightColumnList.get(i));
            }
        }
        return result;
    }

    public void separateIntPerColumn(String s) {
        String[] twoStrings = s.split("   ");
        leftColumnList.add(Integer.parseInt(twoStrings[0]));
        rightColumnList.add(Integer.parseInt(twoStrings[1]));
    }

    public int compareTwoIntegers(int firstInt, int secondInt) {
        int max = Math.max(firstInt, secondInt);
        int min = Math.min(firstInt, secondInt);
        return max - min;
    }

    public int getSumOcurrences(int i) {
        int result = 0;
        for (Integer integer : rightColumnList) {
            if (integer == i)
                result++;
        }
        return result;
    }

    public int calculateLikenessScore() {
        int result = 0;
        for (int i = 0; i < leftColumnList.size(); i++) {
            result += (leftColumnList.get(i) * getSumOcurrences(leftColumnList.get(i)));
        }
        return result;
    }
}
