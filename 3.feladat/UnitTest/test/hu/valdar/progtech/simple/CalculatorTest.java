package hu.valdar.progtech.simple;

import hu.valdar.progtech.calc.Calculator;
import hu.valdar.progtech.calc.CalculatorException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initialize(){
        calculator = new Calculator();
    }

    @Test(expected = CalculatorException.class)
    public void testDividedByZero() throws CalculatorException {
        calculator.divide(5, 0);
    }

    @Test
    public void testDivide() throws CalculatorException {
        Assert.assertEquals("A Calculator divide muvelete hibas pozitiv szamokra!", 4, calculator.divide(20, 5));
        Assert.assertEquals("A Calculator divide muvelete hibas negativ szamokra!", -5, calculator.divide(10, -2));
    }

    @After
    public void tearDown(){
        calculator = null;
    }
}
