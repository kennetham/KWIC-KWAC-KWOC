import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer {

    private List<String> lines;

    public Alphabetizer() {
        this.lines = new ArrayList<String>();
    }

    public void addLines(String[] line) {
        Collections.addAll(this.lines, line);
    }

    public String[] sortLines() {
        Collections.sort(this.lines);

        return this.lines.toArray(new String[this.lines.size()]);
    }
}
