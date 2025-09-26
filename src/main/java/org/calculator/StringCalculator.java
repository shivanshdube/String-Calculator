package org.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;

        String delimiterRegex = ",|\n";
        if (numbers.startsWith("//")) {
            int idx = numbers.indexOf('\n');
            String custom = numbers.substring(2, idx);
            delimiterRegex = Pattern.quote(custom) + "|,|\\n";
            numbers = numbers.substring(idx + 1);
        }

        String[] tokens = numbers.split(delimiterRegex);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String t : tokens) {
            if (t.isEmpty()) continue;
            int value = Integer.parseInt(t);
            if (value < 0) negatives.add(value);
            sum += value;
        }

        if (!negatives.isEmpty()) {
            String msg = "negative numbers not allowed " + negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException(msg);
        }

        return sum;
    }
}
