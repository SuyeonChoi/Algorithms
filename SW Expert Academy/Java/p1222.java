import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t < 11; t++){
            int len = Integer.parseInt(br.readLine());
            String exp = br.readLine();
            int ans = 0;
            for(int i = 0; i < len; i++){
                if(exp.charAt(i) != '+'){
                    ans += Integer.parseInt(String.valueOf(exp.charAt(i)));
                }
            }

            System.out.println("#"+t+" "+ans);
        }
    }
}
