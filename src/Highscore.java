import com.sun.glass.ui.Size;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Eirik on 26.04.2017.
 */
public class Highscore {

    public static HashMap<String, Integer> hsDict = new HashMap<String, Integer>();
    public static Map<String, Integer> hsDictSorted;

    public void addHighscore(String name, int score) {
        hsDict.put(name, score);
    }

    public static Map returnSortedHighscore(HashMap unsorted) {
        hsDictSorted = new TreeMap(new ValueComparator(unsorted));
        hsDictSorted.putAll(unsorted);
        return hsDictSorted;
    }
}
