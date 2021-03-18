package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p7465 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            makeSet(N);
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            Set<Integer> parentSet = new HashSet<>();
            for(int i = 1; i <=N; i++){
                findSet(i);
                parentSet.add(p[i]);
            }
            System.out.println("#"+t+" "+parentSet.size());
        }
    }

    private static void union(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA == rootB) return;
        p[rootB] = rootA;
    }

    private static int findSet(int x) {
        if(p[x] == x) return x;
        else return p[x] = findSet(p[x]);
    }

    private static void makeSet(int n) {
        p = new int[n+1];
        for(int i = 1; i <= n; i++){
            p[i] = i;
        }
    }
}
