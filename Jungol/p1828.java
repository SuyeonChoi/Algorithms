import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] substance = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            substance[i][0] = Integer.parseInt(st.nextToken());
            substance[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(substance, (e1, e2) -> e1[1] - e2[1]);
        int ans = 1, temp = substance[0][1];
        for(int i = 1; i < N; i++){
            if(substance[i][0] <= temp) continue;
            temp = substance[i][1];
            ans++;
        }
        System.out.println(ans);
    }
}
