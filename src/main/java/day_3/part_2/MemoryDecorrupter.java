package day_3.part_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryDecorrupter {
    Pattern extendedPattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)");

    public List<String> createStringListFromMatches(String s) {
        Matcher m = extendedPattern.matcher(s);
        List<String> list = new ArrayList<>();

        boolean isEnabled = true;
        while (m.find()) {
            switch (m.group()) {
                case "don't()" -> isEnabled = false;
                case "do()" -> isEnabled = true;
                default -> {
                    if (isEnabled) {
                        list.add(m.group(0));
                    }
                }
            }
        }
        return list;
    }

    public int multiplyString(String s) {
        String[] strings = s.split(",");
        int x = Integer.parseInt(strings[0].replaceAll("[^\\d]", ""));
        int y = Integer.parseInt(strings[1].replaceAll("[^\\d]", ""));
        return x * y;
    }


}
