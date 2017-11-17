package hu.valdar.progtech.calc;

public class Calculator {

    private static final int ZERO = 0;

    public int divide(int firstNumber, int secondNumber) throws CalculatorException {
        if(ZERO == secondNumber && ZERO != firstNumber){
            throw new CalculatorException("Nullaval valo osztas nem megengedett!");
        }
        return firstNumber / secondNumber;
    }


}
