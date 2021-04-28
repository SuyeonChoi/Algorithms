package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ranking {
    public static void main(String[] args) {
        solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }
    static ArrayList<ArrayList<Integer>> indegree;
    static ArrayList<ArrayList<Integer>> outdegree;
    public static int solution(int n, int[][] results) {
        indegree = new ArrayList<>();
        outdegree = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            indegree.add(new ArrayList<>());
            outdegree.add(new ArrayList<>());
        }
        for(int[] r: results) {
            indegree.get(r[0]).add(r[1]);
            outdegree.get(r[1]).add(r[0]);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = bfs(indegree, i, n) + bfs(outdegree, i, n);
            if (sum == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    private static int bfs(ArrayList<ArrayList<Integer>> graph, int start, int size) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] vis = new boolean[size+1];
        vis[start] = true;

        while (! queue.isEmpty()) {
            int cur = queue.poll();
            for(int nxt: graph.get(cur)) {
                if (!vis[nxt]) {
                    queue.offer(nxt);
                    vis[nxt] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
