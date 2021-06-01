package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    long dist;
    int st;
    int en;

    public Edge(long dist, int st, int en) {
        this.dist = dist;
        this.st = st;
        this.en = en;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.dist, o.dist);
    }
}

public class p1251 {
    static int N;
    static int[][] map;
    static ArrayList<ArrayList<Edge>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][2];
            adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<Edge>());
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j) continue;
                    long weight = (long) (Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2));
                    adj.get(i).add(new Edge(weight, i, j));
                    adj.get(j).add(new Edge(weight, j, i));
                }
            }

            long sum = prim();


            System.out.println("#" + t + " " + Math.round(sum   * E));
        }
    }

    private static long prim() {
        int cnt = 0;
        long sum = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] chk = new boolean[N];
        for (int i = 0; i < adj.get(0).size(); i++) {
            pq.offer(new Edge(adj.get(0).get(i).dist, 0, adj.get(0).get(i).en));
        }
        chk[0] = true;
        while (true) {
            Edge edge = pq.poll();
            long dist = edge.dist;
            int v1 = edge.st;
            int v2 = edge.en;
            if(chk[v2]) continue;
            sum += dist;
            chk[v2] = true;
            cnt++;
            if (cnt == N - 1) break;
            for (int i = 0; i < adj.get(v2).size(); i++) {
                if (! chk[adj.get(v2).get(i).en]) {
                    pq.offer(new Edge(adj.get(v2).get(i).dist, v2, adj.get(v2).get(i).en));
                }
            }
        }
        return sum;
    }
}
