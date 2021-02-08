import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9229 {
    static int[] cookies;
    static int N;
    static int M;
    static int[] selected = new int[2];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cookies = new int[N];
            st = new StringTokenizer(br.readLine());
            ans = -1;
            for (int i = 0; i < N; i++) {
                cookies[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            System.out.println("#" + t + " " + ans);
        }
    }

    private static void comb(int cnt, int st) {
        if (cnt == 2) {
            int sum =selected[0] + selected[1];
            if (sum <= M && ans < sum ) {
                ans = sum;
            }
        } else {
            for (int i = st; i < N; i++) {
                selected[cnt] = cookies[i];
                comb(cnt + 1, i + 1);
            }
        }
    }
}
