package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p9205 {
    static int N;
    static int[][] cvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //inputs
            N = Integer.parseInt(br.readLine());
            cvs = new int[N + 2][2];
            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                cvs[i][0] = Integer.parseInt(st.nextToken());
                cvs[i][1] = Integer.parseInt(st.nextToken());
            }

            int[][] d = new int[N + 2][N + 2];
            boolean[][] chk = new boolean[N + 2][N + 2];
            for (int i = 0; i < N + 2; i++) {
                d[i][i] = 0;
                for (int j = i + 1; j < N + 2; j++) {
                    int dist = calcDist(cvs[i][0], cvs[i][1], cvs[j][0], cvs[j][1]);
                    d[i][j] = dist;
                    d[j][i] = dist;
                    if (dist <= 1000) {
                        chk[i][j] = true;
                        chk[j][i] = true;
                    }
                }
            }
            for (int k = 0; k < N + 2; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        if (i == j || i == k || j == k) continue;
                        if (chk[i][k] && chk[k][j]) {
                            chk[i][j] = true;
                        }
                    }
                }
            }
            //            System.out.println(chk[0][N+1]);
            if (chk[0][N + 1]) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static int calcDist(int curX, int curY, int nxtX, int nxtY) {
        return Math.abs(curX - nxtX) + Math.abs(curY - nxtY);
    }
}
