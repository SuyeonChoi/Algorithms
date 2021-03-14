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

public class p1953 {
    static int N;
    static int M;
    static int R;
    static int C;
    static int L;
    static int[][] map;
    static int[][] vis;
    static Queue<Node> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            queue = new LinkedList<>();
            vis = new int[N][M];
            queue.add(new Node(R, C));
            vis[R][C] = 1;
            int sum = 0;
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                sum++;
                if(vis[x][y] == L) continue;
                int nx, ny;
                switch (map[cur.x][cur.y]) {
                    case 1:
                        for (int dir = 0; dir < 4; dir++) {
                            nx = x + dx[dir];
                            ny = y + dy[dir];
                            if(checkTunnel(nx, ny, x, y)){
                                if(dir == 0){
                                    checkUp(nx, ny, x, y);
                                }else if(dir == 1){
                                    checkDown(nx, ny, x, y);
                                }else if(dir == 2){
                                    checkLeft(nx, ny, x, y);
                                }else{
                                    checkRight(nx, ny, x, y);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (int dir = 0; dir < 2; dir++) {
                            nx = x + dx[dir];
                            if(checkTunnel(nx, y, x, y)){
                            if(dir == 0){
                                checkUp(nx, y, x, y);
                            }else{
                                checkDown(nx, y, x, y);
                            }}
                        }
                        break;
                    case 3:
                        for (int dir = 2; dir < 4; dir++) {
                            ny = y + dy[dir];
                            if(checkTunnel(nx, ny, x, y)){
                            if(dir == 0){
                                checkLeft(x, ny, x, y);
                            }else{
                                checkRight(x, ny, x, y);
                            }
                        }
                        break;
                    case 4:
                        //상
                        nx = x + 1;
                        checkTunnel(nx, y, x, y);
                        checkUp(nx, y, x, y);
                        //우
                        ny = y + 1;
                        checkTunnel(x, ny, x, y);
                        checkRight(x, ny, x, y);
                        break;
                    case 5:
                        //하
                        nx = x - 1;
                        checkTunnel(nx, y, x, y);
                        checkDown(nx, y, x, y);
                        //우
                        ny = y + 1;
                        checkTunnel(x, ny, x, y);
                        checkRight(x, ny, x, y);
                        break;
                    case 6:
                        //하
                        nx = x - 1;
                        checkTunnel(nx, y, x, y);
                        checkDown(nx, y, x, y);
                        //좌
                        ny = y - 1;
                        checkTunnel(x, ny, x, y);
                        checkLeft(x, ny, x, y);
                        break;
                    case 7:
                        //상
                        nx = x + 1;
                        checkUp(nx, y, x, y);
                        checkTunnel(nx, y, x, y);
                        //좌
                        ny = y - 1;
                        checkTunnel(x, ny, x, y);
                        checkRight(x, ny, x, y);
                        break;
                }
            }
            for(int i = 0; i < N; i++){
                System.out.println(Arrays.toString(vis[i]));
            }
            System.out.println("#" + t + " " + sum);
        }
    }

    private static void checkRight(int nx, int ny, int x, int y) {
        if(map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] ==6 || map[nx][ny] == 7){
            vis[nx][ny] = vis[x][y]+ 1;
            queue.add(new Node(nx, ny));
        }
    }

    private static void checkLeft(int nx, int ny, int x, int y) {
        if(map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] ==4 || map[nx][ny] == 5){
            vis[nx][ny] = vis[x][y]+ 1;
            queue.add(new Node(nx, ny));
        }
    }
    

    private static void checkDown(int nx, int ny, int x, int y) {
        if(map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] ==4 || map[nx][ny] == 7){
            vis[nx][ny] = vis[x][y]+ 1;
            queue.add(new Node(nx, ny));
        }
    }

    private static void checkUp(int nx, int ny, int x, int y) {
        if(map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] ==5 || map[nx][ny] == 6){
            vis[nx][ny] = vis[x][y]+ 1;
            queue.add(new Node(nx, ny));
        }
    }

    private static boolean checkTunnel(int nx, int ny, int x, int y) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || vis[nx][ny] != 0) {
            return false;
        }
        return true;

    }
}
