package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Box {
    int x;
    int y;
    int d;

    public Box(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class p7576 {
    static int M;
    static int N;
    static int[][] box;
    static Queue<Box> queue = new LinkedList<>();
    static int minDays = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new Box(i, j, 0));
                }
            }
        }
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0){
                    minDays = -1;
                }
            }
        }
        System.out.println(minDays);
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Box cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;
            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (box[nx][ny] != 0) continue;
                queue.offer(new Box(nx, ny, d + 1));
                box[nx][ny] = 1;
                minDays = Math.max(d + 1, minDays);
            }
        }
    }
}
