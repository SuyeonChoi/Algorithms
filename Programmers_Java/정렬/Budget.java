package Programmers;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget) break;
            sum += d[i];
            answer++;
        }
        return answer;
    }
}
