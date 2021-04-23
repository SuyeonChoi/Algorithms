package Programmers;

import java.util.*;

class Network {
    static LinkedList<LinkedList<Integer>> adj;
    static boolean[] vis;
    public int solution(int n, int[][] computers) {
        adj = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
            for(int j = 0; j < computers[i].length; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        vis = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(! vis[i]) {
                answer++;
                bfs(i);
            }
        }
        return answer;
    }

    public void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while(! queue.isEmpty()) {
            int cur = queue.poll();
            for(int nxt : adj.get(cur)) {
                if(!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(nxt);
                }
            }
        }
    }
}