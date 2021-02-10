import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class p1861 {
    static int N;
    static int[][] room;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxCnt;
    static int maxStartRoom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //bfs
            int[] ans = bfs();

//            dfs
//            maxCnt = 0;
//            maxStartRoom = 0;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    dfs(i, j, 1, room[i][j]);
//                }
//            }

            System.out.println("#" + t + " " + ans[0] + " " + ans[1]);
        }
    }

    private static void dfs(int curX, int curY, int cnt, int start) {

        if (maxCnt < cnt) {
            maxCnt = cnt;
            maxStartRoom = start;
        }else if(maxCnt == cnt){
            maxStartRoom = Math.min(maxStartRoom, start);
        }

        for (int d = 0; d < 4; d++) {
            int nx = curX + dx[d];
            int ny = curY + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && room[nx][ny] == room[curX][curY] + 1) {
                dfs(nx, ny, cnt+1, start);
            }
        }
    }

    private static int[] bfs() {
        int max = 0;
        int num = N * N;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                queue.offer(new Node(i, j));
                int cnt = 1;
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    int x = node.x, y = node.y;
                    for (int n = 0; n < 4; n++) {
                        int nx = x + dx[n], ny = y + dy[n];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (room[nx][ny] != room[x][y] + 1) continue;
                        queue.offer(new Node(nx, ny));
                        cnt++;
                    }
                }
                if (max < cnt) {
                    max = cnt;
                    num = room[i][j];
                }else if(max == cnt){
                    num = Math.min(num, room[i][j]);
                }
            }
        }
        return new int[]{num, max};
    }
}
