package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    // TODO:  create an add method in StringCalculator Class.
    @Test
    void emptyStringTest() {
        assertEquals(0,calculator.add(""));
    }
}
