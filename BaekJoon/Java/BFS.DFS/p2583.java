package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2583 {
    static int M;
    static int N;
    static boolean[][] map;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];
        vis = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            checkSquare(x1, y1, x2, y2);
        }

        List<Integer> list = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j] && !vis[i][j]) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i: list) {
            sb.append(i).append(" ");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static int bfs(int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int area = 1;
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
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (map[nx][ny] || vis[nx][ny]) continue;
                queue.offer(new int[]{nx, ny});
                vis[nx][ny] = true;
                area++;
            }
        }
        return area;
    }

    private static void checkSquare(int x1, int y1, int x2, int y2) {
        for (int i = M - 1 - y1; i > M - 1 - y2; i--) {
            for (int j = x1; j < x2; j++) {
                map[i][j] = true;
            }
        }
    }
}
