package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1681 {
    static int N;
    static int[][] adj;
    static int answer;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        vis = new boolean[N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vis[0] = true;
        dfs(0, 1, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int cnt, int sum) {
        if (sum >= answer) return;
        if (cnt == N) {
            if (adj[start][0] == 0) return;
            answer = Math.min(answer, sum + adj[start][0]);
        } else {
            for (int i = 1; i < N; i++) {
                if (adj[start][i] == 0 || vis[i]) continue;
                vis[i] = true;
                dfs(i, cnt + 1, sum + adj[start][i]);
                vis[i] = false;
            }
        }
    }
}
