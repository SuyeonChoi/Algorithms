package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2564 {
    static int R;
    static int C;
    static int N;
    static int[] store;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        store = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            store[i] = calcDist(dir, dist);
        }
        int minLength = 0;
        for (int i = 0; i < N; i++) {
            int dist = Math.abs(store[N] - store[i]);
            minLength += Math.min(dist, 2 * C + 2 * R - dist);
        }

        System.out.println(minLength);
    }

    private static int calcDist(int dir, int dist) {
        switch (dir) {
            case 1:
                return (R + dist);
            case 2:
                return (2 * R + C + (C - dist));
            case 3:
                return (R - dist);
            case 4:
                return (R + C + dist);
        }
        return 0;
    }
}
