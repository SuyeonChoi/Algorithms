package p2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2178 {
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] maze;
    static int[][] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        maze = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            String temp = scan.next();
            for(int j = 0; j < M; j++){
                maze[i][j] = (int)temp.charAt(j) - '0';
            }
        }
        visited[0][0] = 1;
        bfs(0, 0);
        System.out.println(visited[N-1][M-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= N || ny <0 || ny >= M)
                    continue;
                if(maze[nx][ny] == 0 || visited[nx][ny] != 0)
                    continue;
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
            }
        }
    }
}
