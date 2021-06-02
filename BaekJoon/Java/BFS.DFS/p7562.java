package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7562 {
    static int N;
    static int[][] map;
    static int stX;
    static int stY;
    static int desX;
    static int desY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            stX = Integer.parseInt(st.nextToken());
            stY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            desX = Integer.parseInt(st.nextToken());
            desY = Integer.parseInt(st.nextToken());
            int move = bfs(stX, stY, desX, desY);
            sb.append(move).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int stX, int stY, int desX, int desY) {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        Queue<int[]> queue = new LinkedList<>();
        int[][] vis = initVisitArray();
        queue.offer(new int[]{stX, stY});
        vis[stX][stY] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == desX && y == desY) {
                return vis[x][y];
            }
            for (int idx = 0; idx < 8; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || vis[nx][ny] != -1) continue;
                queue.offer(new int[]{nx, ny});
                vis[nx][ny] = vis[x][y] + 1;
            }
        }
        return 0;
    }

    private static int[][] initVisitArray() {
        int[][] vis = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(vis[i], -1);
        }
        return vis;
    }
}
