import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[length];
            for (int j = 0; j < length; j++) {
                buildings[j] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for (int j = 2; j < length - 2; j++) {
                int height = buildings[j];
                int leftMax = Math.max(buildings[j - 1], buildings[j - 2]);
                int rightMax = Math.max(buildings[j + 1], buildings[j + 2]);
                int finalMax = Math.max(leftMax, rightMax);
                if (height > finalMax) {
                    result += (height - finalMax);
                }
            }
            System.out.println("#" + (i+1) + " " +result);
        }
    }
}
