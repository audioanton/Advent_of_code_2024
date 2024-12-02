package day_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryDecorrupter {
    Pattern p = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");


    public List<String> createStringListFromMatches(String s) {
        Matcher m = p.matcher(s);
        List<String> list = new ArrayList<>();

        if (m.find()) {
            list.add(m.group(0));
            while (true) {
                try {
                    m.find(m.end());
                    list.add(m.group(0));
                } catch (IllegalStateException e) {
                    break;
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
