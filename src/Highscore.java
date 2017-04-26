import java.util.*;


public final class Highscore {

    private static final Highscore h = new Highscore();

    public static Highscore getInstance() {
        return h;
    }

    public static Map<String, Integer> hsDict = new HashMap<String, Integer>();

    public void addHighscore(String name, int score) {
        hsDict.put(name, score);
    }

    public static Map sortHighscore() {
        Map hsDictSorted = new TreeMap(new ValueComparator(hsDict));
        hsDictSorted.putAll(hsDict);
        return hsDictSorted;
    }

    public Map getHighscore() {
        return hsDict;
    }
}
