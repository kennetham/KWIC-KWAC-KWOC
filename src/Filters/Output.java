package Filters;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.EOFException;

public class Output extends Filter {

    @Override
    protected void transform() throws EOFException {
        System.out.println(input.read());
            
    }

}
