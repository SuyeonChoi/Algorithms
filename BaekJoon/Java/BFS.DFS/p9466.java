package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9466 {
    static int N;
    static int[] student;
    static boolean[] visited;
    static boolean[] chkCycle;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            visited = new boolean[N + 1];
            chkCycle = new boolean[N + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < N + 1; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }
            sb.append(N - cnt).append("\n");

        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        int nxt = student[cur];
        if (!visited[nxt]) { // 방문한적 없음
            dfs(nxt);
        } else {
            if (!chkCycle[nxt]) { // 사이클 체크된적 없음
                for (int i = nxt; i != cur; i = student[i]) {
                    cnt++;
                }
                cnt++;
            }
        }
        chkCycle[cur] = true;
    }
}
