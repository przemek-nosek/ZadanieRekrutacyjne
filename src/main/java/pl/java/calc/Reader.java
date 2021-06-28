package pl.java.calc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Reader {
    public static String readLastLine(String file) {
        StringBuilder builder = new StringBuilder();

        try (var in = new RandomAccessFile(file, "r")) {
            long fileLength = in.length() - 1;

            for (long pointer = fileLength; pointer >= 0; pointer--) {
                in.seek(pointer);
                char c = (char) in.read();
                if (c == '\n') {
                    break;
                }
                builder.append(c);
            }
            builder.reverse();

            return builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
