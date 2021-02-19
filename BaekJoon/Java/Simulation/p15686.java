import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p15686 {
    static int N;
    static int M;
    static int[][] city;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();
    static int[] selectedIdx;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        selectedIdx = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2){
                    chicken.add(new Point(i, j));
                }else if(city[i][j] == 1){
                    home.add(new Point(i, j));
                }
            }
        }
        combi(0, 0);

        System.out.println(ans);
    }

    private static void combi(int cnt, int st) {
        if(cnt == M){
            int totalDist = 0;
            for(int i = 0; i < home.size(); i++){
                int hx = home.get(i).x;
                int hy = home.get(i).y;
                int chickenDist = N*N+1;
                for(int j = 0; j < M; j++){
                    int cx = chicken.get(selectedIdx[j]).x;
                    int cy = chicken.get(selectedIdx[j]).y;
                    int tmp = Math.abs(hx - cx) + Math.abs(hy - cy);
                    if(tmp < chickenDist) chickenDist = tmp;
                }
                totalDist += chickenDist;
            }
            if(totalDist < ans) ans = totalDist;
        }else{
            for(int i = st; i < chicken.size(); i++){
                selectedIdx[cnt] = i;
                combi(cnt+1, i+1);
            }
        }
    }
}
