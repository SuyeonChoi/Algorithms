package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Dislike_Same_Number {
    public int[] solution(int []arr) {
        List<Integer> numList = new ArrayList<>();
        numList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == arr[i]) continue;
            numList.add(arr[i]);
        }

        int[] answer = new int[numList.size()];
        int idx = 0;
        for (int n: numList) {
            answer[idx++] = n;
        }
        return answer;
    }
}
