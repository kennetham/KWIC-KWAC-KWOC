import Filters.Alphabetizer;
import Filters.CircularShifter;
import Filters.Input;
import Filters.Output;
import Filters.Pipeline;
import Filters.ShiftFilter;

/*
 * Author: Yeo Quan Yang
 * Matric No.: A0111889W
 */

public class KWICPipeAndFilter {
    public static void main(String[] args ){
        Pipeline p = new Pipeline(
                new Input(),
                new CircularShifter(),
                new ShiftFilter(),
                new Alphabetizer(),
                new Output()
            );
        p.initialize();
    }
}
