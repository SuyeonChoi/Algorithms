import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int R = str.length(), C = 1;
        while (true) {
            if (R * C == str.length() && R <= C) break;
            R--;
            C = str.length() / R;
        }
        char[][] arr = new char[R][C];
        int idx = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                arr[j][i] = str.charAt(idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
    }
}
