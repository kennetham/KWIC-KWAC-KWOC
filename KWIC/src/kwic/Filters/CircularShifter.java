package kwic.Filters;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.EOFException;

public class CircularShifter extends Filter {

    public void leftShift(String[] inputArray) {
        String temp = inputArray[0];
        int i;
        for (i = 0; i < inputArray.length - 1; i++) {
            inputArray[i] = inputArray[i + 1];
        }
        inputArray[i] = temp;
    }

    @Override
    public void transform() throws EOFException {
        String s = this.input.read();
        String[] tokenizedString = s.split("\\s");

        for (int i = 0; i < tokenizedString.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < tokenizedString.length; x++) {
                if (x == 0) {
                    sb.append(tokenizedString[x].toUpperCase());
                    sb.append(" ");
                } else {
                    sb.append(tokenizedString[x].toLowerCase());
                    sb.append(" ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            leftShift(tokenizedString);
            this.output.write(sb.toString());
        }
    }

}
