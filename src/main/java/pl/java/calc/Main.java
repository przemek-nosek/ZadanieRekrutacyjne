package pl.java.calc;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        withBufferedReader();
        withFilesLines();
    }

    private static void withFilesLines() {
        String file = "file2.txt";
        String lastLine = Reader.readLastLine(file);

        Calculator calculator = InputParser.parseLastLine(lastLine);

        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            lines.map(e -> Operation.operate(e, calculator.getInitValue()))
                    .forEach(calculator::setInitValue);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(calculator.getInitValue());
    }


    private static void withBufferedReader() {
        String file = "file.txt";
        String lastLine = Reader.readLastLine(file);

        Calculator calculator = InputParser.parseLastLine(lastLine);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("apply")) {
                    break;
                }
                BigDecimal operate = Operation.operate(line, calculator.getInitValue());
                calculator.setInitValue(operate);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(calculator.getInitValue());
    }

}
