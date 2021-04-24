package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1197 {

    static class Point {
        int u;
        int w;

        public Point(int u, int w) {
            this.u = u;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int u;
        int w;

        public Node(int u, int v, int w) {
            this.v = v;
            this.u = u;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static int V;
    static int E;
    static ArrayList<ArrayList<Point>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj.get(A).add(new Point(B, C));
            adj.get(B).add(new Point(A, C));
        }

        long weight = prim();

        System.out.println(weight);
    }

    private static long prim() {
        long weight = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] chk = new boolean[V+1];
        for(Point p : adj.get(1)) {
            pq.offer(new Node(1, p.u, p.w));
        }
        chk[1] = true;
        int cnt = 0;
        while (true) {
            Node cur = pq.poll();
            int u = cur.u;
            int v = cur.v;
            if (chk[v]) continue;
            weight += cur.w;
            chk[v] = true;
            cnt++;
            if (cnt == V-1) break;
            for (Point p : adj.get(v)) {
                if (chk[p.u]) continue;
                pq.offer(new Node(v, p.u, p.w));
            }
        }
        return weight;
    }
}
