import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        if (N >= 3) {
            for (int i = 0; i < N; i++) {
                int start = 0;
                int end = N - 1;
                boolean isGood = false;
                while (start < end) {
                    if(start == i){
                        start += 1;
                        continue;
                    }
                    if(end == i){
                        end -= 1;
                        continue;
                    }
                    int _sum = arr[start] + arr[end];
                    if (_sum == arr[i]) {
                        isGood = true;
                        break;
                    } else if (_sum < arr[i]) {
                        start += 1;
                    } else {
                        end -= 1;
                    }
                }
                if (isGood) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
