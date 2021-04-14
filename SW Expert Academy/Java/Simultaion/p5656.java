package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, v;

    public Point(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}

public class p5656 {
    // 가장 높이 쌓여있는 각각의 column좌표에 대해
    // 가장 많이 터지는 경우를 계산
    static int N;
    static int W;
    static int H;
    static int[][] bricks;
    static int[][] bricksCopy;
    static Queue<Point> queue;

    static int[] selected;
    static int brokenBricks;
    static int maxBrokenBricks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            bricks = new int[H][W];
            selected = new int[N];
            maxBrokenBricks = 0;
            int totalBricks = 0;
            brokenBricks = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    bricks[i][j] = Integer.parseInt(st.nextToken());
                    if (bricks[i][j] != 0) totalBricks++;
                }
            }
            // 구슬을 N번 떨어뜨릴 때 선택할 수 있는 열에 대한 경우의 수
            makeSet(0);
            //구슬을 던질수 있는 횟수만큼
            System.out.println("#" + t + " " + (totalBricks - maxBrokenBricks));
        }
    }

    private static void makeSet(int cnt) {
        if (cnt == N) {
            bricksCopy = copyArray();
            brokenBricks = 0;
            for (int i = 0; i < N; i++) {
                int x = findH(selected[i]);
                if (x == -1) continue;
                shootMarvel(x, selected[i]);
                sortBricks();
            }
            maxBrokenBricks = Math.max(brokenBricks, maxBrokenBricks);
        } else {
            for (int i = 0; i < W; i++) {
                selected[cnt] = i;
                makeSet(cnt + 1);
            }
        }
    }

    private static void sortBricks() {
        for (int i = 0; i < W; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = H - 1; j >= 0; j--) {
                if (bricksCopy[j][i] != 0) {
                    queue.offer(bricksCopy[j][i]);
                    bricksCopy[j][i] = 0;
                }
            }
            int j = H - 1;
            while (!queue.isEmpty()) {
                bricksCopy[j][i] = queue.poll();
                j--;
            }
        }
    }

    private static int findH(int w) {
        for (int i = 0; i < H; i++) {
            if (bricksCopy[i][w] != 0) {
                return i;
            }
        }
        return -1;
    }

    private static int[][] copyArray() {
        int[][] arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            arr[i] = Arrays.copyOf(bricks[i], W);
        }
        return arr;
    }


    private static void shootMarvel(int x, int y) {
        queue = new LinkedList<>();
        queue.offer(new Point(x, y, bricksCopy[x][y]));
        bricksCopy[x][y] = 0;
        brokenBricks++;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            int range = cur.v;
            //범위만큼 사방탐색
            for (int i = 0; i < range; i++) {
                validation(curX - i, curY);
                validation(curX + i, curY);
                validation(curX, curY - i);
                validation(curX, curY + i);
            }
        }
    }

    private static void validation(int x, int y) {
        if (x < 0 || x >= H || y < 0 || y >= W) return;
        if (bricksCopy[x][y] == 0) return;
        queue.offer(new Point(x, y, bricksCopy[x][y]));
        bricksCopy[x][y] = 0;
        brokenBricks++;
    }
}
