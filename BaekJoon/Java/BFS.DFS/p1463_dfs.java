package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1463_dfs {
    static int[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        vis = new int[N+1];
        Arrays.fill(vis, -1);

//        vis[N] = 0;
        dfs(N, 0);
        System.out.println(vis[1]);
    }

    private static void dfs(int x, int cnt) {
        if(vis[x] <= cnt && vis[x] != -1) return;
        else vis[x] = cnt;
        if (x == 1) {
            return;
        }
        if (x % 3 == 0 && x / 3 > 0) {
            dfs(x / 3, cnt + 1);
        }
        if (x % 2 == 0 && x / 2 > 0) {
            dfs(x / 2, cnt + 1);
        }
        if (x - 1 > 0) {
            dfs(x - 1, cnt + 1);
        }
    }
}
