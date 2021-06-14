package Programmers;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int N = citations.length;
        int[] reverse = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            reverse[i] = citations[N - i];
        }
        for (int i = N; i >= 1; i--) {
            if (reverse[i] >= i) return i;
        }
        return 0;
    }
}
