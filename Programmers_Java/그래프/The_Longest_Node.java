package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class The_Longest_Node {
    static ArrayList<ArrayList<Integer>> adj;

    public int solution(int n, int[][] edge) {
        adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] dist = bfs(n);
        int max = dist[2];
        int answer = 1;
        for (int i = 3; i <= n; i++) {
            if (dist[i] == max) {
                answer++;
            }else if (max < dist[i]) {
                max = dist[i];
                answer = 1;
            }
        }
        return answer;
    }

    private int[] bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        queue.offer(1);
        vis[1] = 0;
        while (! queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : adj.get(cur)) {
                if(vis[nxt] == -1) {
                    queue.offer(nxt);
                    vis[nxt] = vis[cur] + 1;
                }
            }
        }
        return vis;
    }
}
