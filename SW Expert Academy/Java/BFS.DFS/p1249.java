package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Ground{
    int x;
    int y;

    public Ground(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class p1249 {
    static int N;
    static int[][] road;
    static int[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            road = new int[N][N];
            vis = new int[N][N];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                Arrays.fill(vis[i], -1);
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    road[i][j] = Integer.parseInt(tmp[j]);
                }
            }
            bfs();
            System.out.println("#" + t + " " + vis[N-1][N-1]);
        }
    }

    private static void bfs(){
        Queue<Ground> queue = new LinkedList<>();
        queue.offer(new Ground(0, 0));
        vis[0][0] = road[0][0];
        while (!queue.isEmpty()){
            Ground cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int idx = 0; idx < 4; idx++){
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(vis[nx][ny] == -1){
                    queue.offer(new Ground(nx, ny));
                    vis[nx][ny] = vis[x][y] + road[nx][ny];
                }else if(vis[nx][ny] > vis[x][y] + road[nx][ny]){
                    queue.offer(new Ground(nx, ny));
                    vis[nx][ny] = vis[x][y] + road[nx][ny];
                }
            }
        }
    }
}
