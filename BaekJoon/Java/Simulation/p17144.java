package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Area {
    int x;
    int y;
    int v;

    public Area(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}

public class p17144 {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int ar1;
    static int ar2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        boolean findAirCleaner = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && !findAirCleaner) {
                    ar1 = i;
                    ar2 = i + 1;
                    findAirCleaner = true;
                }
            }
        }

        while (T > 0) {
            spreadFineDust();
            processAirCleaner();
            T--;
        }
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0){
                    cnt += map[i][j];
                }
            }
        }
        System.out.println(cnt);
    }

    private static void processAirCleaner() {
        // 위쪽 -> 반시계방향 순환
        rotateCounterClockwise();
        //아래쪽 -> 시계방향 순환
        rotateClockwise();
    }

    private static void rotateClockwise() {
        for (int i = ar2 + 1; i <= R - 2; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i >= ar2 + 1; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i >= 2; i--) {
            map[ar2][i] = map[ar2][i - 1];
        }
        map[ar2][1] = 0;
    }

    private static void rotateCounterClockwise() {
        for (int i = ar1 - 1; i >= 1; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < ar1; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i >= 2; i--) {
            map[ar1][i] = map[ar1][i - 1];
        }
        map[ar1][1] = 0;
    }

    private static void spreadFineDust() {
        Queue<Area> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    queue.offer(new Area(i, j, map[i][j]));
                }
            }
        }

        while (!queue.isEmpty()) {
            Area cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int value = cur.v;
            int cnt = 0;
            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
                map[nx][ny] += (value / 5);
                cnt++;
            }
            map[x][y] -= ((value / 5) * cnt);
        }
    }
}
