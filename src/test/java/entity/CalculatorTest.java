package entity;

import entity.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldNotDivideByZero() {
        // Montagem do cenário
        var dividend = 10d;
        var divisor = 0d;

        // Execução do cenário
        Executable executable = () -> calculator.divide(dividend, divisor);

        // Validação
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void shouldDivideTheDividendByDivisor() {
        // Montagem do cenário
        var dividend = 10d;
        var divisor = 2d;

        // Execução do cenário
        var quotient = calculator.divide(dividend, divisor);

        // Validação
        assertEquals(5d, quotient);
    }
}
