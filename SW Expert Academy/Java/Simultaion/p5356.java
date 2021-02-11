import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxLine = 0;
        for(int t = 1; t <= T; t++){
            char[][] words = new char[5][];
            for(int i = 0; i < 5; i++){
                words[i] = br.readLine().toCharArray();
                if(words[i].length > maxLine) maxLine = words[i].length;
            }
            System.out.print("#"+t+" ");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < maxLine; i++){
                for(int j = 0; j < 5; j++){
                    if(i >= words[j].length) continue;
                    sb.append(words[j][i]);
                }
            }
            System.out.println(sb);
        }
    }
}
