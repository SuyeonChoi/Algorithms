import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1012 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] farm = new int[N][M];
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }
            Queue<Node> queue = new LinkedList<>();
            int[][] vis = new int[N][M];
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(farm[i][j] == 0 || vis[i][j] == 1) continue;
                    queue.add(new Node(i, j));
                    vis[i][j] = 1;
                    cnt++;
                    while (!queue.isEmpty()){
                        Node node = queue.poll();
                        int x = node.x;
                        int y = node.y;
                        for(int d = 0; d < 4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if(vis[nx][ny] == 1 || farm[nx][ny] == 0) continue;
                            vis[nx][ny] = 1;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
