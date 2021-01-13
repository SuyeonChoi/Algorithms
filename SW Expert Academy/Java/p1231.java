import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1231 {
    static int[] lc;
    static int[] rc;
    static String[] alp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            lc = new int[N + 1];
            rc = new int[N + 1];
            alp = new String[N + 1];

            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                alp[u] = st.nextToken();
                if (st.hasMoreTokens()) {
                    lc[u] = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    rc[u] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("#" + t + " ");
            inorder(1);
            System.out.println();

        }
    }

    private static void inorder(int cur) {
        if (lc[cur] != 0) inorder(lc[cur]);
        System.out.print(alp[cur]);
        if (rc[cur] != 0) inorder(rc[cur]);

    }
}
