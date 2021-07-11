package Programmers;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceOfGameMap {
    static int N;
    static int M;

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        int count = bfs(maps);
        return count;
    }

    public int bfs(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        int[][] vis = new int[N][M];
        queue.offer(new Point(0, 0));
        vis[0][0] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            if (x == N - 1 && y == M - 1) return vis[x][y];

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (vis[nx][ny] != 0 || maps[nx][ny] == 0) continue;
                queue.offer(new Point(nx, ny));
                vis[nx][ny] = vis[x][y] + 1;
            }
        }
        return -1;
    }
}
