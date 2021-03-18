import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //미팅하는 사람 수
            int p = Integer.parseInt(st.nextToken()); //은하의 수
            int q = Integer.parseInt(st.nextToken()); // 은하간의 길이의 개수
            int[] people = new int[n];
            //범위!!!
            long[][] d = new long[p + 1][p + 1];
            long longVal = Long.MAX_VALUE / 2;
            for (int i = 0; i < n; i++) {
                people[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= p; i++) {
                Arrays.fill(d[i], longVal);
            }

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                d[a][b] = Math.min(d[a][b], c); //간선이 한개가 아닌 경우 고려
                d[b][a] = Math.min(d[b][a], c);
            }
            for (int i = 1; i <= p; i++) {
                d[i][i] = 0;
            }

            // 플로이드
            for (int k = 1; k <= p; k++) {
                for (int i = 1; i <= p; i++) {
                    for (int j = 1; j <= p; j++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }

            // 최소 지점 찾기
            int univNum = 0;
            long univSum = Long.MAX_VALUE;
            for (int k = 1; k <= p; k++) {
                long sum = 0;
                boolean allReached = true;
                for (int i = 0; i < n; i++) {
                    if (d[people[i]][k] >= longVal) {
                        allReached = false;
                        break;
                    }
                    sum += (d[people[i]][k] * d[people[i]][k]);
                }
                if (allReached && sum < univSum) {
                    univSum = sum;
                    univNum = k;
                }
            }
            System.out.println(univNum + " " + univSum);
        }
    }
}
