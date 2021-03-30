package Programmers;

import java.util.Arrays;

public class Kth_Number {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] c = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(arr, c);
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int st = command[0] - 1;
            int en = command[1] - 1;
            int[] tmp = new int[en - st + 1];
            int idx = 0;
            for (int j = st; j <= en; j++) {
                tmp[idx++] = array[j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[command[2] - 1];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
