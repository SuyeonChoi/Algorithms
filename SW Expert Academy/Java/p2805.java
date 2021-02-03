import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] st = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Integer.parseInt(st[j]);
                }
            }
            int profit = 0;

            //상부 & 가운데
            int cnt = 1;
            for (int i = 0; i <= N / 2; i++) {
                int idx = N / 2 - i;
                for (int j = 0; j < cnt; j++) {
                    profit += farm[i][idx + j];
                }
                cnt = cnt + 2;
            }
//            하부
            cnt -= 4;
            for (int i = N / 2 + 1; i < N; i++) {
                int idx = i - N/2;
                for (int j = 0; j < cnt; j++) {
                    profit += farm[i][idx + j];
                }
                cnt = cnt - 2;
            }

            System.out.println("#" + t + " " + profit);
        }
    }
}
