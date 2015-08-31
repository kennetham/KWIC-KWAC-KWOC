import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Alphabetizer _alphabetizer = new Alphabetizer();
        WordsFilter words_filter = WordsFilter.getInstance();
        List<String> movie_list = new ArrayList<String>();

        Scanner _scanner = new Scanner(System.in);

        System.out.println("Enter movie titles:");

        String user_in = _scanner.nextLine();
        while (!user_in.isEmpty()) {
            movie_list.add(user_in);
            user_in = _scanner.nextLine();
        }

        System.out.println("Words to Ignore:");
        String ignore_words_in = _scanner.nextLine();
        while (!ignore_words_in.isEmpty()) {
            words_filter.addWord(ignore_words_in);
            ignore_words_in = _scanner.nextLine();
        }

        for (String str : movie_list) {
            CircularShift circular_shift = new CircularShift(str);
            _alphabetizer.addLines(circular_shift.getCircularShift());
        }

        String[] results = _alphabetizer.sortLines();
        StringBuilder str_builder = new StringBuilder();
        String separator = System.lineSeparator();

        for (String str : results) {
            str_builder.append(str).append(separator);
        }

        System.out.print(str_builder.toString());
        System.exit(0);
    }
}
