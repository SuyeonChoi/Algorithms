package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2531 {
    static int N;
    static int d;
    static int k;
    static int c;
    static int[] kind;
    static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        kind = new int[d+1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }


        int cur = 0;
        //첫 연속으로 먹는거
        for (int i = 0; i < k; i++) {
            if (kind[sushi[i]] == 0) {
                cur++;
            }
            kind[sushi[i]]++;
        }
        int max = cur;
        for (int i = 1; i < N; i++) {
            //앞에꺼 빼기
            kind[sushi[i - 1]]--;
            if (kind[sushi[i - 1]] == 0) {
                cur--;
            }
            //뒤에꺼 더하기
            if (i + k - 1 >= N) {
                int idx = i + k - 1 - N;
                if (kind[sushi[idx]] == 0) {
                    cur++;
                }
                kind[sushi[idx]]++;
            } else {
                if (kind[sushi[i + k - 1]] == 0) {
                    cur++;
                }
                kind[sushi[i + k - 1]]++;
            }

            //값 업데이트
            if (cur >= max) {
                max = cur;
                if (kind[c] == 0) {
                    max++;
                }
            }
        }

        System.out.println(max);
    }
}
