import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2578 {
    static int[][] bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //빙고판에 쓰여진 수
        bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //사회자가 부르는 수
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cnt++;
                int num = Integer.parseInt(st.nextToken());
                erase(num);
                if (countLine() >= 3) {
                    System.out.println(cnt);
                    return;
                }

            }
        }
    }

    private static int countLine() {
        int bingoLine = 0;
        //가로세로 확인
        for (int i = 0; i < 5; i++) {
            boolean rowLine = true, colLine = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) {
                    rowLine = false;
                }
                if (bingo[j][i] != 0) {
                    colLine = false;
                }
            }
            if (rowLine) bingoLine++;
            if (colLine) bingoLine++;
        }
        //대각선 확인
        boolean diaLine1 = true, diaLine2 = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) {
                diaLine1 = false;
            }
            if (bingo[i][4-i] != 0) {
                diaLine2 = false;
            }
        }
        if (diaLine1) bingoLine++;
        if (diaLine2) bingoLine++;

        return bingoLine;
    }

    private static void erase(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }
}
