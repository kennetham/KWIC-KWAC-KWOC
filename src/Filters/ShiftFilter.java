package Filters;
/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.EOFException;
import java.util.Arrays;

public class ShiftFilter extends Filter {
    
    public static final String[] wordsToIgnore = {"is", "the", "of", "and", "as", "a", "after"};

    @Override
    protected void transform() throws EOFException {
        String buffer = input.read();
        String[] tokenizedBuffer = buffer.split("\\s");
        if (!Arrays.asList(wordsToIgnore).contains(tokenizedBuffer[0].toLowerCase())) {
            output.write(buffer);
        }
    }

}
