package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1681 {
    static int N;
    static int[][] cost;
    static boolean[] vis;
    static int min;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE / 2;
        for (int i = 1; i < N; i++) {
            vis = new boolean[N];
            sum = 0;
            if (cost[0][i] != 0) {
                dfs(0, i, 1);
            }
        }
        System.out.println(min);
    }

    private static void dfs(int x, int y, int cnt) {
        if (sum > min) {
            return;
        }
        sum = sum + cost[x][y];
        vis[x] = true;
        if (cnt == (N - 1)) {
            sum = sum + cost[y][0];
            if (cost[y][0] == 0) {
                return;
            }
            min = Math.min(min, sum);
            sum = sum - cost[y][0];
            return;
        }


        for (int i = 0; i < N; i++) {
            if (!vis[i] && cost[y][i] != 0 && (sum < min)) {
                dfs(y, i, cnt + 1);
                sum = sum - cost[y][i];
                vis[i] = false;
            }
        }
    }
}
