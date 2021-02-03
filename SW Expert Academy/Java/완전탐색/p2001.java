import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2001 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for(int i = 0; i <= N-M; i++){
                for(int j = 0; j <= N-M; j++){
                    int tmp = deadFly(arr,i, j);
                    if(max < tmp){
                        max = tmp;
                    }
                }
            }
            System.out.println("#"+t+" "+max);
        }

    }

    private static int deadFly(int[][] arr, int x, int y) {
        int flies = 0;
        for(int i = x; i < x + M; i++){
            for(int j = y; j < y +M; j++){
                flies += arr[i][j];
            }
        }
        return flies;
    }
}
