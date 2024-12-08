package day_7.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperatorCalibrator {
    long matcher;
    long sum;

    public OperatorCalibrator() {
        sum = 0;
    }

    public void calibrateOperators(String line) {
        Long[] operands = getTestAndOperands(line);
        List<Long> results = iterateAllOperands(operands);

        if (isMatch(results)) {
            sum += matcher;
            System.out.println(sum);
        }
    }

    public boolean isMatch(List<Long> results) {
        Collections.sort(results);
        int index = Collections.binarySearch(results, matcher);
        return index >= 0;
    }

    public Long[] getTestAndOperands(String line) {
        String[] res = line.split(": | ");
        Long[] result = new Long[res.length-1];
        for (int i = 1; i < res.length; i++) {
            result[i-1] = Long.parseLong(res[i]);
        }
        matcher = Long.parseLong(res[0]);
        return result;
    }

    public List<Long> iterateAllOperands(Long[] operands) {
        int maxIterations = operands.length-1;
        List<Long> result = Arrays.asList(operands[0]);

        for (int i = 1; i <= maxIterations; i++) {
            List<Long> temp = iterateLayer(result, operands, i);
            result = temp;
        }
        return result;
    }

    public Long[] calculateTwoOperands(long first, long second) {
        long i = first + second;
        long j = first * second;
        String s = Long.toString(first) + second;
        long k = Long.parseLong(s);
        return new Long[]{i, j, k};
    }

    public List<Long> iterateLayer(List<Long> previousLayer, Long[] originalOperands, int iterations) {
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < previousLayer.size(); i++) {
            Long[] array = calculateTwoOperands(previousLayer.get(i), originalOperands[iterations]);
            result.add(array[0]);
            result.add(array[1]);
            result.add(array[2]);
        }


        return result;
    }
}
