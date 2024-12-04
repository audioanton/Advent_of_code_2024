package day_4.part_1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmasFinder {
    Pattern pattern = Pattern.compile("XMAS|SAMX");


    public int getSumXmasHorizontal(String s) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.delete(0, sb.length());
            if (s.length() > i+3) {
                sb.append(s.charAt(i)).append(s.charAt(i+1)).append(s.charAt(i+2)).append(s.charAt(i+3));
                Matcher matcher = pattern.matcher(sb);
                if (matcher.find())
                    sum++;
            }
        }
        return sum;
    }

    public int getSumXmasVertical(List<String> lines) {
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            for (int y = 0; y < lines.get(i).length(); y++) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(lines.get(i).charAt(y));
                    sb.append(lines.get(i+1).charAt(y));
                    sb.append(lines.get(i+2).charAt(y));
                    sb.append(lines.get(i+3).charAt(y));
                    if (sb.toString().matches(pattern.pattern()))
                        sum++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        return sum;
    }

    public int getSumXmasDiagonalRightDirection(List<String> lines) {
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            for (int y = 0; y < lines.get(i).length(); y++) {
                try {
                    StringBuilder sb = new StringBuilder();
                    if (lines.get(i).length() > y+3) {
                        sb.append(lines.get(i).charAt(y));
                        sb.append(lines.get(i + 1).charAt(y + 1));
                        sb.append(lines.get(i + 2).charAt(y + 2));
                        sb.append(lines.get(i + 3).charAt(y + 3));
                    }
                    if (sb.toString().matches(pattern.pattern()))
                        sum++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }
        return sum;
    }

    public int getSumXmasDiagonalLeftDirection(List<String> lines) {
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            for (int y = 0; y < lines.get(i).length(); y++) {
                try {
                    StringBuilder sb = new StringBuilder();
                    if (y-3 > -1) {
                        sb.append(lines.get(i).charAt(y));
                        sb.append(lines.get(i + 1).charAt(y - 1));
                        sb.append(lines.get(i + 2).charAt(y - 2));
                        sb.append(lines.get(i + 3).charAt(y - 3));
                    }
                    if (sb.toString().matches(pattern.pattern()))
                        sum++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }
        return sum;
    }

    public int getSumXmasFromStringList(List<String> stringList) {
        int sum = 0;
        for (String line : stringList)
            sum += getSumXmasHorizontal(line);
        sum += getSumXmasVertical(stringList);
        sum += getSumXmasDiagonalRightDirection(stringList);
        sum += getSumXmasDiagonalLeftDirection(stringList);
        return sum;
    }
}
