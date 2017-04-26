import com.sun.glass.ui.Size;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Eirik on 26.04.2017.
 */
public final class Highscore {

    private static final Highscore h = new Highscore();

    public static Highscore getInstance() {
        return h;
    }

    public static Map<String, Integer> hsDict = new HashMap<String, Integer>();
    public static Map<String, Integer> hsDictSorted;

    public void addHighscore(String name, int score) {
        hsDict.put(name, score);
        SortHighscore();
    }

    public static void SortHighscore() {
        hsDictSorted = new TreeMap(new ValueComparator(hsDict));
        hsDictSorted.putAll(hsDict);
        hsDict = hsDictSorted;
    }
}
