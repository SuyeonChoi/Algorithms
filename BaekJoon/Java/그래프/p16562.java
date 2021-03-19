package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p16562 {
    static int[] parent;
    static int[] friendPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        friendPrice = new int[N + 1];
        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friendPrice[i] = Integer.parseInt(st.nextToken());
        }
        makeSet(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
        Set<Integer> group = new HashSet<>();
        int totalCost = 0;
        for (int i = 1; i <= N; i++) {
            int p = findSet(i);
            if (group.contains(p))
                continue;
            group.add(p);
            totalCost += friendPrice[p];
        }
        if(totalCost <= K){
            System.out.println(totalCost);
        }else{
            System.out.println("Oh no");
        }
    }

    private static void union(int x, int y) {
        int x_parent = findSet(x);
        int y_parent = findSet(y);
        if (x_parent == y_parent) return;
        if (friendPrice[x_parent] < friendPrice[y_parent]) {
            parent[y_parent] = x_parent;
        } else {
            parent[x_parent] = y_parent;
        }
    }

    private static int findSet(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = findSet(parent[x]);
    }

    private static void makeSet(int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
}
