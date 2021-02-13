import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String D = st.nextToken();
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] state = new boolean[B + 1];
            Arrays.fill(state, true);
            state[1] = false;
            for (int i = 2; i * i <= B; i++) {
                for (int j = i * i; j <= B; j = j + i) {
                    state[j] = false;
                }
            }

            int ans = 0;
            for (int i = A; i <= B; i++) {
                if (state[i] && Integer.toString(i).contains(D)) {
                    ans++;
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
