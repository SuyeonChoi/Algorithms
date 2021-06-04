package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickAndAdd {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for(int i: set) {
            answer[idx++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}
