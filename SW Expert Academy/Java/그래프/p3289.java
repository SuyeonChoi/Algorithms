package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3289 {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            makeSet(N);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case 0:
                        union(x, y);
                        break;
                    case 1:
                        if (findSet(x) == findSet(y)) {
                            sb.append(1);
                        } else {
                            sb.append(0);
                        }
                        break;
                }
            }
            System.out.println("#" + t + " " + sb);
        }
    }

    private static boolean union(int x, int y) {
        int xParent = findSet(x);
        int yParent = findSet(y);
        if(xParent == yParent) return false;
        p[yParent] = xParent;
        return true;
    }

    private static int findSet(int x) {
        if (x == p[x]) return x;
        else return p[x] = findSet(p[x]);
    }

    private static void makeSet(int n) {
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }
}
