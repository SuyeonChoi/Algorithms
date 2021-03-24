package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p2636 {
    static int R;
    static int C;
    static int[][] cheese;
    static int[][] visited;
    static Queue<Node> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0; //치즈 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cheese = new int[R][C];
        visited = new int[R][C];
        queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], -1);
            for (int j = 0; j < C; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) cnt++;
            }
        }

        int beforeHour = 0;
        int hour = 0;
        while (cnt > 0) {
            beforeHour = cnt;
            hour++;
            bfs();
        }

        System.out.println(hour);
        System.out.println(beforeHour);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];
        queue.offer(new Node(0, 0));
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || vis[nx][ny]) continue;
                if (cheese[nx][ny] == 0) {
                    queue.offer(new Node(nx, ny));
                } else {
                    cheese[nx][ny] = 0;
                    cnt--;
                }
                vis[nx][ny] = true;
            }
        }
    }
}
