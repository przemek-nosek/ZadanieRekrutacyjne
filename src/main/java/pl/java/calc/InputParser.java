package pl.java.calc;

import java.math.BigDecimal;

public class InputParser {

    public static Calculator parseLastLine(String line) {
        String[] tokens = line.split(" ");
        if (tokens.length != 2 || !tokens[0].equalsIgnoreCase("apply")) {
            throw new IllegalArgumentException("Bad argument");
        }
        BigDecimal initValue = new BigDecimal(tokens[1]);

        return new Calculator(initValue);
    }
}
