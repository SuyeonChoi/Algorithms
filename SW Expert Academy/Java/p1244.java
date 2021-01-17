import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class p1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] digits = Stream.of(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            int change = Integer.parseInt(st.nextToken());
            int idx = 0;
            while (change > 0) {
                int[] tmp = Arrays.copyOfRange(digits, idx, digits.length);
                int maxIdx = findMax(tmp);
                int tmpVal = digits[idx];
                digits[idx] = digits[maxIdx];
                digits[maxIdx] = tmpVal;
                idx++;
                change--;
            }
            System.out.print("#" + T + " ");
            for (int i = 0; i < digits.length; i++) System.out.print(digits[i]);
            System.out.println();
        }
    }

    private static int findMax(int[] tmp) {
        int max = tmp[0];
        int idx = 0;
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
                idx = i;
            }
        }
        return idx;
    }
}
