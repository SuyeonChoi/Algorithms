import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1992 {
    static StringBuilder str = new StringBuilder();
    static int[][] image;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        image = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                image[i][j] = line.charAt(j) - '0';
            }
        }
        divide_and_conquer(0, N, 0, N);
        System.out.println(str);
    }

    private static void divide_and_conquer(int stI, int enI, int stJ, int enJ) {
        if(enI - stI <= 1){
            str.append(image[stI][stJ]);
            return;
        }
        int flag = isDiff(stI, enI, stJ, enJ);
        if (2 == flag) { //배열의 요소가 다른경우
            str.append("(");
            divide_and_conquer(stI, stI + (enI - stI)/2, stJ, stJ + (enJ - stJ) /2); //1사분면
            divide_and_conquer(stI, stI + (enI - stI)/2, stJ + (enJ - stJ) /2, enJ); //2사분면
            divide_and_conquer(stI + (enI - stI)/2, enI, stJ, stJ + (enJ - stJ) /2); //3사분면
            divide_and_conquer(stI + (enI - stI)/2, enI, stJ + (enJ - stJ) /2, enJ); //4사분면
            str.append(")");
        } else {
            str.append(flag);
        }
    }

    private static int isDiff(int stI, int enI, int stJ, int enJ) {
        int flag = image[stI][stJ];
        for (int i = stI; i < enI && flag != 2; i++) {
            for (int j = stJ; j < enJ; j++) {
                if (flag != image[i][j]) {
                    flag = 2;
                    return 2;
                }
            }
        }
        return flag;
    }
}
