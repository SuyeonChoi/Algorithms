import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1211 {
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
                }
            }
            int[] lengthArr = findX(ladder);
            int minIdx = 0;
            int minLength = lengthArr[0];
            for(int i = 1; i < 100; i++){
                if(lengthArr[i] != 0 && minLength >= lengthArr[i]){
                    minIdx = i;
                    minLength = lengthArr[i];
                }
            }
            System.out.println("#" + idx + " " + minIdx);
        }

    }

    private static int[] findX(int[][] ladder) {
        int[] result = new int[100];
        for (int i = 0; i < 100; i++) {
            int curRow = 0;
            int curCol = i;
            int length = 1;
            int[][] vis = new int[100][100];
            vis[curRow][curCol] = 1;
            if (ladder[curRow][curCol] == 0) {
                continue;
            }
            while (curRow < 100) {
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
                length++;
            }
            result[i] = length;
        }
        return result;

    }
}
