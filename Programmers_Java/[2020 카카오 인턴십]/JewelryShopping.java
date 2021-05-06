package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JewelryShopping {
    public static void main(String[] args) {
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
//        solution(new String[]{"XYZ", "XYZ", "XYZ"});
    }

    public static int[] solution(String[] gems) {
        int N = gems.length;
        Set<String> jewelry = new HashSet<>();
        for (int i = 0; i < N; i++) {
            jewelry.add(gems[i]);
        }

        int J = jewelry.size();
        HashMap<String, Integer> hold = new HashMap<>();
        int st = 0;
        int en = 0;
        int dist = N;
        int[] answer = new int[2];
        for (int i = 0; i < N; i++) {
            hold.put(gems[i], hold.getOrDefault(gems[i], 0) + 1);
            en = i;

            while (hold.size() == J) {
                if (st < en && hold.get(gems[st]) > 1) {
                    hold.put(gems[st], hold.get(gems[st]) - 1);
                    st++;
                } else {
                    break;
                }
            }

            if (hold.size() == J && (en - st) < dist) {
                answer[0] = st + 1;
                answer[1] = en + 1;
            }

        }

        return answer;
    }
}
