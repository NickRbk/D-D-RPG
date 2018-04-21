package cursor.rybak.model.maze.compass;

import java.util.LinkedList;
import java.util.List;

public class ListUtil {
    public static <T> List<T> reverse(List<T> list) {
        int length = list.size();
        List<T> result = new LinkedList<>();

        for (int i = length - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }

    public static <T> List<T> copy(List<T> list) {
        int length = list.size();
        List<T> result = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            result.add(list.get(i));
        }

        return result;
    }
}
