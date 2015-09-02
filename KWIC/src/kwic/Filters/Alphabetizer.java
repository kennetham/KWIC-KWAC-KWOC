package kwic.Filters;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.EOFException;
import java.util.concurrent.ConcurrentSkipListSet;

public class Alphabetizer extends Filter {

    private final ConcurrentSkipListSet<String> buffer = new ConcurrentSkipListSet<String>();

    @Override
    public void transform() throws EOFException {
        try {
        String temp = this.input.read();
        buffer.add(temp);
        } catch (EOFException e) {
            while (!buffer.isEmpty()) {
                this.output.write(buffer.pollFirst());
            }
            throw e;
        }
    }

}
