import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16926 {
    static int[][] arr;
    static int[][] vis;
    static int N;
    static int M;
    static int R;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        vis = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int I = Math.min(M, N);
        for (int i = 0; i < I / 2; i++) {
            for (int r = 0; r < R; r++) {
                int idx = 0;
                int x = i, y = i;
                int tmp = arr[x][y];
                while (idx < 4) {
                    int nx = x + dx[idx], ny = y + dy[idx];
                    if (nx >= i && nx < N - i && ny >= i && ny < M - i) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        idx++;
                    }
                }
                arr[i + 1][i] = tmp;
            }

        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
