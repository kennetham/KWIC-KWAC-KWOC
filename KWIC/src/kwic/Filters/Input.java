package kwic.Filters;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Input extends Filter {

    private final BufferedReader reader;

    public Input(javax.swing.JTextArea input) {
        reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getText().getBytes(StandardCharsets.UTF_8))));
    }

    @Override
    protected void transform() throws EOFException {
        String read = null;
        try {
            read = reader.readLine();
        } catch (IOException e) {
        }
        
        if (read == null) {
            throw new EOFException();
        } else {
            output.write(read);
        }
    }

}
