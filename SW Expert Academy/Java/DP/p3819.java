package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class p3819 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int TC = scan.nextInt();
        for (int t = 1; t <= TC; t++) {
            int N = scan.nextInt();
            int[] dp = new int[N];

            dp[0] = scan.nextInt();
            long ans = dp[0];
            for (int i = 1; i < N; i++) {
                int num = scan.nextInt();
                dp[i] = Math.max(dp[i - 1] + num, num);
                ans = Math.max(dp[i], ans);
            }
            System.out.println(Arrays.toString(dp));
            System.out.println("#" + t + " " + ans);
        }
    }
}
