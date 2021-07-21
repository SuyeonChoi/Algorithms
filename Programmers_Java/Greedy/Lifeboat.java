package Programmers;

import java.util.*;

public class Lifeboat {
    public int solution(int[] peoples, int limit) {
        int answer = 0;

        Arrays.sort(peoples);

        int min = 0;

        for (int max = peoples.length - 1; min <= max; max--){
            if (peoples[min] + peoples[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}
