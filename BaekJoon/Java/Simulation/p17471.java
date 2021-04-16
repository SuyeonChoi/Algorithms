package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17471 {
    static int N;
    static int[] weight;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int R;
    static boolean[] isSelected;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                adj.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        // nC1 ~ nCn/2까지 경우의 수 생성
        for (int i = 1; i <= N / 2; i++) {
            isSelected = new boolean[N];
            R = i;
            combi(0, 0);
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void combi(int cnt, int start) {
        if (cnt == R) {
            int group1 = 0;
            int group2 = 0;

            // 연결 확인
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    int sum = bfs(i, true);
                    if (sum == -1) return;
                    group1 = sum;
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                if (!isSelected[i]) {
                    int sum = bfs(i, false);
                    if (sum == -1) return;
                    group2 = sum;
                    break;
                }
            }
            answer = Math.min(answer, Math.abs(group1 - group2));
        } else {
            for (int i = start; i < N; i++) {
                isSelected[i] = true;
                combi(cnt + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }

    private static int bfs(int i, boolean t) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[N];
        queue.offer(i);
        vis[i] = true;
        int sum = weight[i];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (isSelected[v] == t && !vis[v]) {

                    vis[v] = true;
                    queue.offer(v);
                    sum += weight[v];
                }
            }
        }
        if (t) {
            for (int j = 0; j < N; j++) {
                if (isSelected[j] != vis[j]) {
                    return -1;
                }
            }
        } else {
            for (int j = 0; j < N; j++) {
                if (isSelected[j] == vis[j]) {
                    return -1;
                }
            }
        }

        return sum;
    }
}
