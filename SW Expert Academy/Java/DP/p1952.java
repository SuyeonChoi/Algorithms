import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[] charge = new int[4];
            int[] usePrice = new int[12];
            int[] dp = new int[12];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                charge[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 12; i++) {
                usePrice[i] = Integer.parseInt(st.nextToken());
                int tmp = Math.min(usePrice[i] * charge[0], charge[1]);
                if(i ==0){
                    dp[i] = tmp;
                }else if(i == 1){
                    dp[i] = dp[i-1] + tmp;
                }else{
                    int before = 0;
                    if(i >= 3) before = dp[i-3];
                    dp[i] = Math.min(dp[i - 1] + tmp, before + charge[2]);
                }
            }
            System.out.println("#" + t + " " + Math.min(dp[11], charge[3]));
        }
    }
}
