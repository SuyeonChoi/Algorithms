package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p14502 {
    static int N;
    static int M;
    static int[][] map;
    static int[] num = new int[3];
    static int maxSafeZone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        maxSafeZone = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(maxSafeZone);
    }

    private static void combi(int cnt, int st) {
        if (cnt == 3) {
            int[][] tmpMap = copyMap();
            int safteyzone = bfs(tmpMap);
            maxSafeZone = Math.max(bfs(tmpMap), maxSafeZone);
        } else {
            for (int i = st; i < N * M; i++) {
                if (!isWall(i)) continue;
                num[cnt] = i;
                combi(cnt + 1, i + 1);
            }
        }
    }

    private static int[][] copyMap() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            int x = num[i] / M;
            int y = num[i] % M;
            tmp[x][y] = 1;
        }
        return tmp;
    }

    private static int bfs(int[][] tmpMap) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Pos> queue = new LinkedList<>();
        //초기 바이러스 큐에 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 2) {
                    queue.offer(new Pos(i, j));
                }
            }
        }

        //bfs
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (tmpMap[nx][ny] == 0) {
                    tmpMap[nx][ny] = 2;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }

        //안전 영역
        int safteyZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 0) {
                    safteyZone++;
                }
            }
        }
        return safteyZone;
    }

    private static boolean isWall(int i) {
        int x = i / M;
        int y = i % M;
        if (map[x][y] == 0) {
            return true;
        }
        return false;
    }
}
