import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            if(str[i] == ' ') continue;
            else{
                System.out.print(str[i]);
            }
        }
        System.out.println(sb);
    }
}
