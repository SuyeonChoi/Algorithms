package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5643 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> indegree;
    static ArrayList<ArrayList<Integer>> outdegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            indegree = new ArrayList<>();
            outdegree = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                indegree.add(new ArrayList<>());
                outdegree.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                indegree.get(v).add(u);
                outdegree.get(u).add(v);
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                boolean[] vis = new boolean[N];
                int in = bfs(indegree, i, vis);
                int out = bfs(outdegree, i, vis);
                if (in + out == N - 1) {
                    ans++;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static int bfs(ArrayList<ArrayList<Integer>> graph, int i, boolean[] vis) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph.get(cur)) {
                if (!vis[nxt]) {
                    queue.offer(nxt);
                    vis[nxt] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
