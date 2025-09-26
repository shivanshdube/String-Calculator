package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringTest() {
        assertEquals(0,calculator.add(""));
    }

    @Test
    void addSingleNumberTest() {
        assertEquals(1,calculator.add("1"));
    }

    // TODO: handle comma separated string in add method
    @Test
    void addTwoNumberCommaSeparatedTest() {
        assertEquals(6,calculator.add("1,5"));
    }
}
