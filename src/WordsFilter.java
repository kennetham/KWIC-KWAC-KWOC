import java.util.HashSet;

public class WordsFilter {

    private static WordsFilter _instance;
    private HashSet<String> ignore_set;

    private WordsFilter() {
        this.ignore_set = new HashSet<String>();
    }

    // Singleton
    public static WordsFilter getInstance() {
        if (_instance == null) {
            _instance = new WordsFilter();
        }

        return _instance;
    }

    public void addWord(String _word) {
        assert (_word != null);
        this.ignore_set.add(_word);
    }

    public void removeWord(String _word) {
        assert (_word != null);
        this.ignore_set.remove(_word);
    }

    public boolean containWord(String _word) {
        assert (_word != null);
        return this.ignore_set.contains(_word);
    }
}
