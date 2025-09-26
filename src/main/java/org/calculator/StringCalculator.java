package org.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private int callCount = 0;

    public int add(String numbers) {
        callCount++;

        if (numbers == null || numbers.isEmpty()) return 0;

        String delimiterRegex = ",|\n";

        if (numbers.startsWith("//")) {
            int idx = numbers.indexOf('\n');
            String delimiterSection = numbers.substring(2,idx);

            List<String> delimiters = new ArrayList<>();

            if(delimiterSection.startsWith("[")) {
                Matcher m = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);

                while (m.find()) {
                    delimiters.add(Pattern.quote(m.group(1)));
                }
            } else {
                delimiters.add(Pattern.quote(delimiterSection));
            }

            delimiterRegex = String.join("|", delimiters);
            numbers = numbers.substring(idx + 1);

        }

        String[] tokens = numbers.split(delimiterRegex);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String t : tokens) {
            if (t.isEmpty()) continue;

            int value = Integer.parseInt(t);

            if (value < 0) {
                negatives.add(value);
            } else if (value <= 1000) {
                sum += value;
            }
        }

        if (!negatives.isEmpty()) {
            String msg = "negative numbers not allowed " + negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException(msg);
        }

        return sum;
    }

    public int getCalledCount() {
        return callCount;
    }
}
