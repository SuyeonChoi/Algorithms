package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2468 {
    static int N;
    static int[][] map;
    static boolean[][] vis;
    static int maxSafeArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxSafeArea = 1;
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        for (int i = 1; i < maxH; i++) {
            maxSafeArea = Math.max(maxSafeArea, calcSafeArea(i));
        }
        System.out.println(maxSafeArea);
    }

    private static int calcSafeArea(int rain) {
        int safeArea = 0;
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > rain && !vis[i][j]) {
                    bfs(i, j, rain);
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    private static void bfs(int i, int j, int rain) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (vis[nx][ny] || map[nx][ny] <= rain) continue;
                queue.offer(new int[]{nx, ny});
                vis[nx][ny] = true;
            }

        }
    }
}
