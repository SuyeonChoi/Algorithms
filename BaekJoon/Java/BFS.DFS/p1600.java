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
    int k;

    public Node(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}

public class p1600 {
    static int K;
    static int W;
    static int H;
    static int[][] arr;
    static int[][][] vis;
    static Queue<Node> queue;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        arr = new int[H][W];
        vis = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        vis[0][0][0] = 1;
        queue.offer(new Node(0, 0, 0));
        bfs();

    }

    private static void bfs() {
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int k = cur.k;
            if (x == H - 1 && y == W - 1) {
                flag = true;
                System.out.println(vis[x][y][k] - 1);
                break;
            }
            if (k < K) {
                //원숭이식 움직이기
                monkeyBFS(x, y, k);
                //말식 움직이기
                horseBFS(x, y, k);
            } else {
                //원숭이식 움직이기만 가능
                monkeyBFS(x, y, k);
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    private static void horseBFS(int x, int y, int k) {
        for (int idx = 0; idx < 8; idx++) {
            int nx = x + hx[idx];
            int ny = y + hy[idx];
            if (nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1 || vis[nx][ny][k + 1] != 0) {
                continue;
            }
            vis[nx][ny][k + 1] = vis[x][y][k] + 1;
            queue.offer(new Node(nx, ny, k + 1));
        }
    }

    private static void monkeyBFS(int x, int y, int k) {
        for (int idx = 0; idx < 4; idx++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if (nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1 || vis[nx][ny][k] != 0) {
                continue;
            }
            vis[nx][ny][k] = vis[x][y][k] + 1;
            queue.offer(new Node(nx, ny, k));
        }
    }
}
