package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int size = N.length();
        int[] numbers = new int[10];

        for (int i = 0; i < size; i++) {
            numbers[N.charAt(i) - '0']++;
        }

        int set = 0;
        while (true) {
            if (allZero(numbers)) break;
            set++;
            for (int i = 0; i < 10; i++) {
                if (i == 6) {
                    if(numbers[6] == 0 && numbers[9] > 0) {
                        numbers[9]--;
                        continue;
                    }
                }else if (i == 9) {
                    if(numbers[9] == 0 && numbers[6] > 0) {
                        numbers[6]--;
                        continue;
                    }
                }
                if (numbers[i] <= 0) continue;
                numbers[i]--;

            }
        }

        System.out.println(set);
    }

    private static boolean allZero(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        if (sum == 0) return true;
        return false;
    }
}
