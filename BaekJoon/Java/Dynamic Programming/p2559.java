import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[N];
        dp[0] = arr[0];
        for(int i = 1; i < K; i++){
            dp[i] = dp[i-1] + arr[i];
        }
        int max = dp[K-1];
        for (int i = K; i < N; i++) {
            dp[i] = dp[i - 1] - arr[i - K] + arr[i];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
