package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int[][] land = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            // Row
            for (int i = 0; i < N; i++) {
                int[] row = Arrays.copyOf(land[i], N);
                boolean[] vis = new boolean[N];
                boolean check = true;
                for (int j = 1; j < N; j++) {
                    if (row[j - 1] == row[j]) continue;
                    else if (row[j - 1] - row[j] == 1) {
                        int height = row[j];
                        vis[j] = true;
                        boolean install = true;
                        for (int k = 1; k < X; k++) {
                            j++;
                            if (j >= N || row[j] != height || vis[j]) {
                                install = false;
                                break;
                            }
                            vis[j] = true;
                        }
                        if (!install) {
                            check = false;
                            break;
                        }
                    } else if (row[j] - row[j - 1] == 1) {
                        int height = row[j - 1];
                        vis[j - 1] = true;
                        boolean install = true;
                        for (int k = 1; k < X; k++) {
                            if (j - 1 - k < 0 || row[j - 1 - k] != height || vis[j - 1 - k]) {
                                install = false;
                                break;
                            }
                            vis[j - 1 - k] = true;
                        }
                        if (!install) {
                            check = false;
                            break;
                        }
                    } else { //높이가 2이상 차이나면 활주로 건설 못함
                        check = false;
                        break;
                    }
                }
                if (check) cnt++;
            }

            // Col
            int c = 0;
            for (int i = 0; i < N; i++) {
                int[] col = new int[N];
                boolean[] vis = new boolean[N];
                for (int j = 0; j < N; j++) {
                    col[j] = land[j][i];
                }
                boolean check = true;
                for (int j = 1; j < N; j++) {
                    if (col[j - 1] == col[j]) continue;
                    else if (col[j - 1] - col[j] == 1) {
                        int height = col[j];
                        vis[j] = true;
                        boolean install = true;
                        for (int k = 1; k < X; k++) {
                            j++;
                            if (j >= N || col[j] != height || vis[j]) {
                                install = false;
                                break;
                            }
                            vis[j] = true;
                        }
                        if (!install) {
                            check = false;
                            break;
                        }
                    } else if (col[j] - col[j - 1] == 1) {
                        int height = col[j - 1];
                        boolean install = true;
                        vis[j - 1] = true;
                        for (int k = 1; k < X; k++) {
                            if (j - 1 - k < 0 || col[j - 1 - k] != height || vis[j - 1 - k]) {
                                install = false;
                                break;
                            }
                            vis[j - 1 - k] = true;
                        }
                        if (!install) {
                            check = false;
                            break;
                        }
                    } else { //높이가 2이상 차이나면 활주로 건설 못함
                        check = false;
                        break;
                    }
                }
                if (check) {
                    cnt++;
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}
