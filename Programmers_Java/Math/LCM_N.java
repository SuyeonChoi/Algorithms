package Programmers;

import java.util.Arrays;

public class LCM_N {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int lcm = arr[arr.length - 1];
        while (true) {
            int i;
            for (i = 0; i < arr.length; i++) {
                if (lcm % arr[i] != 0) break;
            }
            if (i == arr.length) break;
            lcm++;
        }

        return lcm;
    }
}
