package Programmers;

import java.util.*;

class MakeMin {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int N = A.length;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += (A[i] * B[N - 1 - i]);
        }

        return answer;
    }
}
