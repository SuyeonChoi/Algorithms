package Programmers;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
    static int[] first = {1, 2, 3, 4, 5};
    static int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int N = answers.length;
        int[] cnt = new int[3];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (first[idx % 5] == answers[i]) cnt[0]++;
            if (second[idx % 8] == answers[i]) cnt[1]++;
            if (third[idx % 10] == answers[i]) cnt[2]++;
            idx++;
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        List<Integer> tmp = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                tmp.add(i);
            }
        }
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i) + 1;
        }
        return answer;
    }


}
