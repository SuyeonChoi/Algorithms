import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1987 {
    static boolean[] alpha = new boolean[26];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] board;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        alpha[board[0][0] - 65] = true;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int depth) {
        if(ans < depth) {
            ans = depth;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (alpha[board[nx][ny] - 65]) continue;
            alpha[board[nx][ny] - 65] = true;
            dfs(nx, ny, depth+1);
            alpha[board[nx][ny] - 65] = false;
        }
    }
}
