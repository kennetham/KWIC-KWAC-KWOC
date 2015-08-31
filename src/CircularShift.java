import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CircularShift {

    public static String DELIMITER = " ";
    private WordsFilter words_ignore;
    private String _line;

    public CircularShift(String line) {
        assert (line != null);
        this._line = line.toLowerCase();
        this.words_ignore = WordsFilter.getInstance();
    }

    public String[] getCircularShift() {
        String[] words = this._line.split(DELIMITER);
        String[] shifts = new String[words.length];
        shifts[0] = this._line;

        for (int i = 1; i < words.length; i++) {
            shifts[i] = this.getShiftedLine(i, words);
        }

        String[] filtered_shift = getShifts(shifts);

        for (int i = 0; i < filtered_shift.length; i++) {
            filtered_shift[i] = capitalizeWords(filtered_shift[i]);
        }

        return filtered_shift;
    }

    private String getShiftedLine(int index, String[] words) {
        StringBuilder str_builder = new StringBuilder();

        for (int i = index; i < words.length; i++) {
            str_builder.append(words[i]);
            str_builder.append(DELIMITER);
        }
        for (int i = 0; i < index; i++) {
            str_builder.append(words[i]);
            str_builder.append(DELIMITER);
        }
        if (str_builder.length() > 0) {
            str_builder.deleteCharAt(str_builder.length() - 1);
        }

        return str_builder.toString();
    }

    private String[] getShifts(String[] shifts) {
        List<String> shift_list = new ArrayList<String>(Arrays.asList(shifts));

        Iterator<String> iterator = shift_list.iterator();
        while (iterator.hasNext()) {
            if (shiftStartingWithIgnoredWord(iterator.next())) {
                iterator.remove();
            }
        }

        return shift_list.toArray(new String[shift_list.size()]);
    }

    private boolean shiftStartingWithIgnoredWord(String line) {
        return this.words_ignore.containWord(line.split(DELIMITER)[0]);
    }

    private String capitalizeWords(String shift) {
        String[] words = shift.split(DELIMITER);
        StringBuilder str_builder = new StringBuilder();

        for (String str : words) {
            if (this.words_ignore.containWord(str)) {
                str_builder.append(str);
            } else if (str.trim().isEmpty()) {
                continue;
            } else {
                str_builder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1));
            }
            str_builder.append(DELIMITER);
        }
        if (str_builder.length() > 0) {
            str_builder.deleteCharAt(str_builder.length() - 1);
        }

        return str_builder.toString();
    }
}
