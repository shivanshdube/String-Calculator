package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void add_emptyString_returnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void add_singleNumber_returnsValue() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void add_twoNumbers_commaSeparated() {
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    void add_multipleNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(10, calc.add("1,2,3,4"));
    }

    @Test
    void add_newlinesBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void add_customDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test
    void add_negativeNumber_throws() {
        StringCalculator calc = new StringCalculator();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calc.add("-1"));
        assertEquals("negative numbers not allowed -1", ex.getMessage());
    }

    @Test
    void add_multipleNegatives_showAll() {
        StringCalculator calc = new StringCalculator();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calc.add("2,-4,-9,3"));
        assertEquals("negative numbers not allowed -4,-9", ex.getMessage());
    }

}
