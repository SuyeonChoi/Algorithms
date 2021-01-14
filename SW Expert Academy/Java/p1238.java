import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t < 11; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            //그래프(인접리스트) 생성
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            //그래프 초기화
            for (int i = 0; i < 101; i++) {
                adj.add(new ArrayList<Integer>());
            }
            //인접 정점 정보 입력
            for (int i = 0; i < len; i = i + 2) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
            }

            //BFS로 탐색
            Queue<Integer> queue = new LinkedList<Integer>();
            int[] vis = new int[101];
            queue.add(start);
            vis[start] = 1;
            int max = 0;
            while (! queue.isEmpty()){
                int v = queue.poll();
                if(vis[v] > max) max = vis[v];
                for(int i = 0; i < adj.get(v).size(); i++){
                    int nxt = adj.get(v).get(i);
                    if(vis[nxt] == 0){
                        queue.add(nxt);
                        vis[nxt] = vis[v]+1;
                    }
                }
            }
            int ans = 0;
            for(int i = 100; i >= 0; i--){
                if(vis[i] == max) {
                    ans = i;
                    break;
                }
            }

            System.out.println("#" + t + " "+ ans);
        }
    }
}
