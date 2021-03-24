package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p1463_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] vis = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(vis, -1);
        queue.offer(N);
        vis[N] = 0;

        //bfs
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == 1) break;
            if (x % 3 == 0 && x / 3 > 0 && vis[x / 3] == -1) {
                vis[x / 3] = vis[x] + 1;
                queue.offer(x / 3);
            }
            if (x % 2 == 0 && x / 2 > 0 && vis[x / 2] == -1) {
                vis[x / 2] = vis[x] + 1;
                queue.offer(x / 2);
            }
            if (x - 1 > 0 && vis[x - 1] == -1) {
                vis[x - 1] = vis[x] + 1;
                queue.offer(x - 1);
            }
        }
        System.out.println(vis[1]);
    }
}
