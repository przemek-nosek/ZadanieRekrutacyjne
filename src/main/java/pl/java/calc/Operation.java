package pl.java.calc;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public enum Operation {
    ADD(BigDecimal::add),
    SUBTRACT(BigDecimal::subtract),
    MULTIPLY(BigDecimal::multiply),
    DIVIDE(BigDecimal::divide);

    private final BinaryOperator<BigDecimal> command;

    Operation(BinaryOperator<BigDecimal> command) {
        this.command = command;
    }

    public static BigDecimal operate(String line, BigDecimal sum) {
        String[] tokens = line.split(" ");
        if (tokens[0].equalsIgnoreCase("apply")) {
            return sum;
        }

        if (tokens.length != 2) {
            throw new IllegalArgumentException("Wrong format");
        }
        BigDecimal value = new BigDecimal(tokens[1]);

        return Operation.valueOf(tokens[0].toUpperCase()).command.apply(sum, value);
    }
}
