package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1868 {
    static int N;
    static char[][] map;
    static int[][] bomb;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static int ans;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            bomb = new int[N][N];
            vis = new boolean[N][N];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            // 숫자로 미로 재구성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        vis[i][j] = true;
                    }else {
                        bomb[i][j] = findBomb(i, j);
                    }
                }
            }
            int click = 0;
            // 0칸부터 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (bomb[i][j] == 0 && !vis[i][j]) {
                        bfs(i, j);
                        click++;
                    }
                }
            }
            // 나머지 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j]) {
                        click++;
                    }
                }
            }
            System.out.println("#" + (tc + 1) + " " + click);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int idx = 0; idx < 8; idx++) {
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || vis[nx][ny]) continue;
                if (bomb[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    vis[nx][ny] = true;
                }
                vis[nx][ny] = true;
            }
        }
    }

    private static int findBomb(int i, int j) {
        int cnt = 0;
        for (int idx = 0; idx < 8; idx++) {
            int nx = i + dx[idx];
            int ny = j + dy[idx];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (map[nx][ny] == '*') cnt++;
        }
        return cnt;
    }

    private static char[][] copyMap(char[][] originMap) {
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = originMap[i][j];
            }
        }
        return arr;
    }
}
