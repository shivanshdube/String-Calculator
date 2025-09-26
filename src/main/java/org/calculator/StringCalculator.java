package org.calculator;

import java.util.regex.Pattern;

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
        for (String t : tokens) {
            if (t.isEmpty()) continue;
            sum += Integer.parseInt(t);
        }
        return sum;
    }
}
