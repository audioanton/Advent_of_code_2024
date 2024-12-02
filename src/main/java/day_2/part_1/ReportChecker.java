package day_2.part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportChecker {
    public boolean isIncreasingSafe(int firstInt, int secondInt) {
        int distance = secondInt - firstInt;
        return (distance >= 1 && distance <= 3);
    }

    public boolean isDecreasingSafe(int firstInt, int secondInt) {
        int distance = firstInt - secondInt;
        return (distance >= 1 && distance <= 3);
    }

    public boolean isRowSafe(boolean b, boolean b2) {
        return ((b && !b2) || (!b && b2));
    }

    public boolean checkRow(List<Integer> row) {
        boolean increasingSafe = true;
        boolean decreasingSafe = true;

        for (int i = 0; i < row.size()-1; i++) {
            if (!isIncreasingSafe(row.get(i), row.get(i + 1))) {
                increasingSafe = false;
                break;
            }
        }

        for (int i = 0; i < row.size()-1; i++) {
            if (!isDecreasingSafe(row.get(i), row.get(i + 1))) {
                decreasingSafe = false;
                break;
            }
        }

        return isRowSafe(increasingSafe, decreasingSafe);
    }

    public List<Integer> createListPerRow(String inputRow) {
        try (Scanner scanner = new Scanner(inputRow)) {
            List<Integer> result = new ArrayList<>();
            while (scanner.hasNextInt()) {
                result.add(scanner.nextInt());
            }
            return result;
        }
    }

}
