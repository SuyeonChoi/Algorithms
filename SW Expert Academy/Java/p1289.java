import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] origin = br.readLine().toCharArray();
            char flag = '0';
            int cnt = 0;
            for (int i = 0; i < origin.length; i++) {
                if (flag != origin[i]) {
                    cnt++;
                    flag = origin[i];
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
