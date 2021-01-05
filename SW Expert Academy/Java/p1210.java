import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int idx = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];
            int DesX = 0, DesY = 0;
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (ladder[i][j] == 2) {
                        DesX = i;
                        DesY = j;
                    }
                }
            }
            int startPoint = findX(ladder, DesX, DesY);
            System.out.println("#" + idx + " " + startPoint);
        }

    }

    private static int findX(int[][] ladder, int desX, int desY) {
        for (int i = 0; i < 100; i++) {
            int curRow = 0;
            int curCol = i;
            int[][] vis = new int[100][100];
            vis[curRow][curCol] = 1;
            if (ladder[curRow][curCol] == 0) {
                continue;
            }
            while (curRow < 100) {
                if (curRow == desX && curCol == desY) {
                    return i;
                }
                if ((curCol + 1) < 100 && ladder[curRow][curCol + 1] == 1 && vis[curRow][curCol + 1] == 0) {
                    curCol += 1;
                    vis[curRow][curCol] = 1;
                } else if ((curCol - 1) >= 0 && ladder[curRow][curCol - 1] == 1 && vis[curRow][curCol - 1] == 0) {
                    curCol -= 1;
                    vis[curRow][curCol] = 1;
                } else {
                    curRow += 1;
                    if (curRow < 100) {
                        vis[curRow][curCol] = 1;
                    }
                }
            }
        }
        return -1;

    }
}
