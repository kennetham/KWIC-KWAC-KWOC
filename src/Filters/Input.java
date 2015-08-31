package Filters;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input extends Filter {

    private BufferedReader reader;

    public Input() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    protected void transform() throws EOFException {
        String read = null;
        try {
            read = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read == null) {
            throw new EOFException();
        } else {
            output.write(read);
        }
    }

}
