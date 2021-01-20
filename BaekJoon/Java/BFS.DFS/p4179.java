import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4179 {
    static int R;
    static int C;
    static int[][] visJH;
    static int[][] visFire;
    static char[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R][C];
        visFire = new int[R][C];
        visJH = new int[R][C];
        Queue<Node> queueJH = new LinkedList<>();
        Queue<Node> queueFire = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                maze[i][j] = str[j].charAt(0);
                if (maze[i][j] == 'J') {
                    queueJH.add(new Node(i, j));
                    visJH[i][j] = 1;
                }
                if (maze[i][j] == 'F') {
                    queueFire.add(new Node(i, j));
                    visFire[i][j] = 1;
                }
            }
        }

        bfsFire(queueFire);
        int ans = bfsJH(queueJH);
        if(ans == 0){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(ans);
        }
    }

    private static void bfsFire(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (maze[nx][ny] == '.' && visFire[nx][ny] == 0) {
                    visFire[nx][ny] = visFire[x][y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    private static int bfsJH(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    return visJH[x][y];
                }
                if (maze[nx][ny] == '.' && visJH[nx][ny] == 0) {
                    if(visFire[nx][ny] == 0 || visFire[nx][ny] > visJH[x][y]+1){
                        visJH[nx][ny] = visJH[x][y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
        return 0;
    }
}
