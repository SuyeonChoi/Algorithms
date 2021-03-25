package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = arr[0];
            int size = 1;
            for (int i = 0; i < N; i++) {
                if(dp[size] < arr[i]){
                    //increase
                    dp[size++] = arr[i];
                }else{

                }
//                if (tmp < 0) {
//                    tmp = Math.abs(tmp) + 1; //중복값이 없는 경우 탐색에 실패하고 음수 리턴
//                }
//                dp[tmp] = arr[i];
//                if (tmp == size) size++;

            }
            System.out.println("#" + t + " " + size);
        }
    }
}
