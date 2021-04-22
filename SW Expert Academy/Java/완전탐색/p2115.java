package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2115 {
    static int N;
    static int M;
    static int C;
    static int[][] hive;
    static int profit;
    // 조합 변수
    static int[] numbers = new int[2];
    // 부분집합 변수
    static int[] honey;
    static boolean[] isSelected;
    static int maxHoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            hive = new int[N][N];
            profit =0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    hive[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combi(0, 0);
            System.out.println("#" + (tc + 1) + " " + profit);
        }
    }

    private static void combi(int start, int cnt) {
        if (cnt == 2) {
            if (numbers[0] + M - 1 >= numbers[1]) return;
            if ((numbers[0] % N) + M - 1 >= N) return;
            if ((numbers[1] % N) + M - 1 >= N) return;
            int sum = 0;
            sum += collectHoney(numbers[0] / N, numbers[0] % N);
            sum += collectHoney(numbers[1] / N, numbers[1] % N);
            profit = Math.max(profit, sum);
        } else {
            for (int i = start; i <= N * N - M; i++) {
                numbers[cnt] = i;
                combi(i + 1, cnt + 1);
            }
        }
    }

    private static int collectHoney(int x, int y) {
        int sum = 0;
        int result = 0;
        honey = new int[M];
        for (int i = 0; i < M; i++) {
            sum += hive[x][y + i];
            result += (hive[x][y + i] * hive[x][y + i]);
            honey[i] = hive[x][y + i];
        }
        if (sum > C) {
            isSelected = new boolean[M];
            maxHoney = 0;
            powerSet(0);
            result = maxHoney;
        }
        return result;
    }

    private static int powerSet(int cnt) {
        if (cnt == M) {
            int sum = 0;
            int result = 0;
            for (int i = 0; i < M; i++) {
                if (isSelected[i]) {
                    sum += honey[i];
                    result += (honey[i] * honey[i]);
                }
            }
            if (sum <= C) {
                maxHoney = Math.max(maxHoney, result);
            }
        }else{
            isSelected[cnt] = true;
            powerSet(cnt + 1);
            isSelected[cnt] = false;
            powerSet(cnt + 1);
        }
        return 0;
    }
}
