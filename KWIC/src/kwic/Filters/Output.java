package kwic.Filters;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.EOFException;

public class Output extends Filter {
       
    private final javax.swing.JTextArea output;
    
    public Output(javax.swing.JTextArea output) {
        this.output = output;
    }

    @Override
    protected void transform() throws EOFException {
        output.setText((output.getText()+"\n"+input.read()).trim());
        
    }

}
