import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6808 {
    static int[] gy;
    static int[] my;
    static int win;
    static int lose;
    static int[] myCase;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gy = new int[9]; //규영 카드
            my = new int[9]; //민영 카드
            isSelected = new boolean[9];
            myCase = new int[9];
            boolean[] cards = new boolean[19];
            win = 0;
            lose = 0;
            for (int i = 0; i < 9; i++) {
                int card = Integer.parseInt(st.nextToken());
                gy[i] = card;
                cards[card] = true;
            }
            int idx = 0;
            for (int i = 1; i < 19; i++) {
                if (!cards[i]) {
                    my[idx++] = i;
                }
            }

            playGame(0);
            System.out.println("#" + t + " " + win + " " + lose);

        }
    }

    private static void playGame(int cnt) {
        if (cnt == 9) { //게임
            int gyScore = 0, myScore = 0;
            for (int i = 0; i < 9; i++) {
                if (gy[i] > myCase[i]) {
                    gyScore += (gy[i] + myCase[i]);
                } else {
                    myScore += (gy[i] + myCase[i]);
                }
            }
            if (gyScore > myScore) win++;
            else if (gyScore < myScore) lose++;
            return;
        } else {
            for (int i = 0; i < my.length; i++) {
                if (isSelected[i]) continue;
                myCase[cnt] = my[i];
                isSelected[i] = true;
                playGame(cnt + 1);
                isSelected[i] = false;
            }
        }

    }
}
