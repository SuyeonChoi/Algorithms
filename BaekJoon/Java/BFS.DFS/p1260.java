import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1260 {
    static int N;
    static int M;
    static int V;
    static ArrayList<ArrayList<Integer>> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] vis = new boolean[N + 1];

        vis[V] = true;
        dfs(V, vis);
        System.out.println(sb);
        bfs();
    }

    private static void dfs(int cur, boolean[] vis) {
        sb.append(cur).append(" ");
        Collections.sort(list.get(cur));
        for(int nxt: list.get(cur)){
            if(!vis[nxt]){
                vis[nxt] = true;
                dfs(nxt, vis);
            }
        }
    }

    private static void bfs() {
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[N + 1];
        queue.offer(V);
        vis[V] = true;
        sb.append(V).append(" ");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int nxt : list.get(u)) {
                if (!vis[nxt]) {
                    queue.offer(nxt);
                    vis[nxt] = true;
                    sb.append(nxt).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}

