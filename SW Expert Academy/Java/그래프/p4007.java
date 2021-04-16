package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4007 {
    static class Pair implements Comparable<Pair> {
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }

    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<Pair>> adj;
    static ArrayList<ArrayList<Pair>> reverseAdj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken()) - 1;
            adj = new ArrayList<>();
            reverseAdj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
                reverseAdj.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int t = Integer.parseInt(st.nextToken());
                adj.get(s).add(new Pair(e, t));
                reverseAdj.get(e).add(new Pair(s, t));
            }

            int max = 0;
            int[] go = dijkstra(X, adj);
            int[] back = dijkstra(X, reverseAdj);
            for (int i = 0; i < N; i++) {
                if(i == X) continue;
                max = Math.max(max, go[i] + back[i]);
            }
            System.out.println("#" + tc + " " + max);
        }
    }

    private static int[] dijkstra(int x, ArrayList<ArrayList<Pair>> tmpAdj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] d = new int[N];
        Arrays.fill(d, Integer.MAX_VALUE);

        d[x] = 0;
        pq.offer(new Pair(x, d[x]));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int dist = cur.w;
            int idx = cur.v;
            if (d[idx] != dist) continue;
            for (Pair nxt : tmpAdj.get(idx)) {
                int cost = nxt.w;
                int nidx = nxt.v;
                if (d[nidx] > dist + cost) {
                    d[nidx] = dist + cost;
                    pq.offer(new Pair(nidx, d[nidx]));
                }
            }
        }
        return d;
    }

}
