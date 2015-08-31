package Filters;
/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.io.EOFException;

public abstract class Filter implements Runnable {
    
    protected Pipe input;
    protected Pipe output;
    
    public Filter() {
        
    }
    
    public Filter(Pipe input, Pipe output) {
        this.input = input;
        this.output = output;
    }
    
    public void setInputPipe(Pipe input) {
        this.input = input;
    }
    
    public void setOutputPipe(Pipe output) {
        this.output = output;
    }
    
    protected abstract void transform() throws EOFException;
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                this.transform();
            } catch (EOFException e) {
                if (output != null) {
                    this.output.close();
                }
                break;
            }
        }
    }

}
