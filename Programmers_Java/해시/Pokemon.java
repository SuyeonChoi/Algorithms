package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Pokemon {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums){
            set.add(n);
        }
        int r = nums.length / 2;

        int answer = set.size();
        if (r < set.size()) {
            answer = r;
        }

        return answer;
    }
}
