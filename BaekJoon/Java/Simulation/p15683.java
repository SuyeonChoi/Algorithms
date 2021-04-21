package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p15683 {
    static class Camera {
        int x;
        int y;
        int type;
        int dir;

        public Camera(int x, int y, int type, int dir) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.dir = dir;
        }
    }

    static int N;
    static int M;
    static int[][] office;
    static int[][] copyOffice;
    static ArrayList<Camera> cctv = new ArrayList<>();
    static int cams = 0;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        min = M * N;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 6 && office[i][j] != 0) {
                    cctv.add(new Camera(i, j, office[i][j], 0));
                    cams++;
                }
            }
        }

        dfs(0);
        System.out.println(min);
    }

    private static void dfs(int cnt) {
        if (cnt == cams) {
            copyArray();
            bfs();
            min = Math.min(blindSpot(), min);
//            if (min > blindSpot()) {
//                min =blindSpot();
//                for (int i = 0; i < N; i++) {
//                    System.out.println(Arrays.toString(copyOffice[i]));
//                }
//                System.out.println();
//            }
        } else {
            for (int i = 0; i < 4; i++) { //회전
                cctv.get(cnt).dir = i;
                dfs(cnt + 1);
            }
        }
    }

    private static int blindSpot() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyOffice[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Camera> queue = new LinkedList<>();
        for (Camera c : cctv) {
            queue.offer(c);
        }

        while (!queue.isEmpty()) {
            Camera cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int type = cur.type;
            int dir = cur.dir;

            switch (type) {
                case 1:
                    watch(x, y, dir);
                    break;
                case 2:
                    watch(x, y, dir);
                    watch(x, y, (dir + 2) % 4);
                    break;
                case 3:
                    watch(x, y, dir);
                    watch(x, y, (dir + 1) % 4);
                    break;
                case 4:
                    watch(x, y, dir);
                    watch(x, y, (dir + 1) % 4);
                    watch(x, y, (dir + 2) % 4);
                    break;
                case 5:
                    watch(x, y, 0);
                    watch(x, y, 1);
                    watch(x, y, 2);
                    watch(x, y, 3);
                    break;
            }
        }
    }

    private static void watch(int x, int y, int dir) {
        if (dir == 0) { //위쪽
            for (int nx = x - 1; nx >= 0; nx--) {
                if (copyOffice[nx][y] == 6) break;
                if (copyOffice[nx][y] == 0) {
                    copyOffice[nx][y] = -1;
                }
            }
        } else if (dir == 2) { //아래
            for (int nx = x + 1; nx < N; nx++) {
                if (copyOffice[nx][y] == 6) break;
                if (copyOffice[nx][y] == 0) {
                    copyOffice[nx][y] = -1;
                }
            }
        } else if (dir == 1) { //오른쪽
            for (int ny = y + 1; ny < M; ny++) {
                if (copyOffice[x][ny] == 6) break;
                if (copyOffice[x][ny] == 0) {
                    copyOffice[x][ny] = -1;
                }
            }
        } else if (dir == 3) { //왼쪽
            for (int ny = y - 1; ny >= 0; ny--) {
                if (copyOffice[x][ny] == 6) break;
                if (copyOffice[x][ny] == 0) {
                    copyOffice[x][ny] = -1;
                }
            }
        }
    }

    private static void copyArray() {
        copyOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyOffice[i][j] = office[i][j];
            }
        }
    }
}
