package Filters;
/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

import java.util.LinkedList;
import java.io.EOFException;

public class Pipe {
    private LinkedList<String> buffer;
    private boolean closed;
    private static int TIME_OUT = 20;
    
    public Pipe() {
        buffer = new LinkedList<String>();
        closed = false;
    }
    
    public void write(String input) {
        if (closed) {
            return;
        } else {
            buffer.add(input);
        }
    }
    
    public String read() throws EOFException {
        while (true) {
            if (buffer.isEmpty()) {
                if (closed) {
                    throw new EOFException();
                } else {
                    try {
                        Thread.sleep(TIME_OUT);
                    } catch (InterruptedException e) {
                        
                    }
                }
            } else {
                return buffer.pop();
            }
        }
    }
    
    public boolean isClosed() {
        return closed;
    }
    
    public void close() {
        closed = true;
    }
}
