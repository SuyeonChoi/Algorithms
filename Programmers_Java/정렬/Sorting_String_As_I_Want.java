package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting_String_As_I_Want {
    static int idx;

    public String[] solution(String[] strings, int n) {
        idx = n;
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(idx) == o2.charAt(idx)) {
                    return o1.compareTo(o2);
                }
                return o1.charAt(idx) - o2.charAt(idx);
            }
        });
        return strings;
    }
}
