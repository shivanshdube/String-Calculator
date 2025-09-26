package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringTest() {
        assertEquals(0,calculator.add(""));
    }

    // TODO handle addition of a single no string
    void addSingleNumberTest() {
        assertEquals(1,calculator.add("1"));
    }
}
