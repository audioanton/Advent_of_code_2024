package day_4.part_2;

import java.util.List;
import java.util.regex.Pattern;

public class XmasFinder {
    Pattern pattern = Pattern.compile("MAS|SAM");
    List<String> stringList;

    public XmasFinder(List<String> stringList) {
        this.stringList = stringList;
    }

    public int getSumXmasDiagonalBothDirections() {
        int sum = 0;

        for (int listIndex = 0; listIndex < stringList.size(); listIndex++) {
            for (int stringIndex = 0; stringIndex < stringList.get(listIndex).length(); stringIndex++) {
                try {
                    StringBuilder builder = new StringBuilder();
                    if (stringList.get(listIndex).length() >= stringIndex+2) {
                        builder.append(stringList.get(listIndex).charAt(stringIndex));
                        builder.append(stringList.get(listIndex + 1).charAt(stringIndex + 1));
                        builder.append(stringList.get(listIndex + 2).charAt(stringIndex + 2));
                    }
                    if (builder.toString().matches(pattern.pattern())) {
                        if (isMatchDiagonalLeftDirection(listIndex, stringIndex))
                            sum++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }
        return sum;
    }

    public boolean isMatchDiagonalLeftDirection(int listIndex, int lineIndex) {
        StringBuilder builder = new StringBuilder();
        if ((lineIndex + 2) > 1) {
            builder.append(stringList.get(listIndex).charAt(lineIndex + 2));
            builder.append(stringList.get(listIndex + 1).charAt(lineIndex + 1));
            builder.append(stringList.get(listIndex + 2).charAt(lineIndex));
            if (builder.toString().matches(pattern.pattern()))
                return true;
        }
        return false;
    }
}
