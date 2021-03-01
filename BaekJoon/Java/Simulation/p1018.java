import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class p1018 {
    static int N, M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        int ans = 65;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            if (i + 8 > N) break;
            for (int j = 0; j < M; j++) {
                if (j + 8 > M) break;
                int changed = countSquare(i, j);
                ans = Math.min(ans, changed);
            }
        }
        System.out.println(ans);
    }

    private static int countSquare(int stR, int stC) {

        int change = 0;
        for (int i = stR; i < stR + 8; i++) {
            char color = arr[i][stC];
            for (int j = stC+1; j < stC + 8; j++) {
//                if (i == stR && j == stC) continue;
                if (color == arr[i][j]) {
                    change++;
                }
                if (color == 'W') color = 'B';
                else color = 'W';
            }
        }
        return change;
    }
}
