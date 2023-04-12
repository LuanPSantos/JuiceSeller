package entity;

public class Calculator {

    public Double divide(Double dividend, Double divisor) {
        if(divisor == 0) {
            throw new IllegalArgumentException("Divisor can not be zero");
        }

        return dividend / divisor;
    }
}
