package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void add_emptyString_returnsZero() {
        assertEquals(0,calculator.add(""));
    }

    @Test
    void add_singleNumber_returnsValue() {
        assertEquals(1,calculator.add("1"));
    }

    @Test
    void add_twoNumbers_commaSeparated() {
        assertEquals(6,calculator.add("1,5"));
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


}
