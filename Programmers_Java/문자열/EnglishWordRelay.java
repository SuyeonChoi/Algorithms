package Programmers;

import java.util.HashSet;
import java.util.Set;

public class EnglishWordRelay {
    public int[] solution(int n, String[] words) {
        if (words[0].length() == 1) return new int[]{1, 1};

        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() <= 1
                    || wordSet.contains(words[i])
                    || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            wordSet.add(words[i]);
        }
        return new int[]{0, 0};
    }
}
