package CodingTest;

import java.util.HashSet;
import java.util.Set;

// 해시. 짝짓기
public class DevMatching_2021_1 {
    public static void main(String[] args) {
        int[] l = {44, 1, 0, 0, 31, 25};
        int[] w = {31, 10, 45, 1, 6, 19};
        solution(l, w);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> valid = new HashSet<>();
        int zeros = 0;
        for (int n : lottos) {
            if (n == 0) {
                zeros++;
            } else {
                valid.add(n);
            }
        }
        int minMatch = 0;
        for (int n : win_nums){
            if(valid.contains(n)){
                minMatch++;
            }
        }
        int maxMatch = minMatch + zeros;
        int[] answer = new int[2];
        answer[0] = rank(maxMatch);
        answer[1] = rank(minMatch);

        return answer;
    }

    private static int rank(int match) {
        if(7 - match <= 5){
            return 7 - match;
        }
        return 6;
    }
}
