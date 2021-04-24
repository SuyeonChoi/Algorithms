package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753 {
    static class Point implements Comparable<Point> {
        int v;
        long w;

        public Point(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (this.w - o.w);
        }
    }

    static int V;
    static int E;
    static int K;
    static ArrayList<ArrayList<Point>> graph;
    static long[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        d = new long[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            d[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Point(v, w));
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (d[i] == Long.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        d[K] = 0;
        pq.offer(new Point(K, d[K]));
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            long dist = cur.w;
            int idx = cur.v;
            if (d[idx] != dist) continue;
            for (Point p: graph.get(idx)) {
                int nidx = p.v;
                long cost = p.w;
                if (d[nidx] > dist + cost) {
                    d[nidx] = dist + cost;
                    pq.offer(new Point(nidx, d[nidx]));
                }
            }
        }
    }
}
