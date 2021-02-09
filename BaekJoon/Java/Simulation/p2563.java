import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int a = 0; a < 10; a++){
                for(int b= 0; b < 10; b++){
                    paper[x+a][y+b] = 1;
                }
            }
        }
        int ans = 0;
        for(int a = 0; a < 100; a++){
            for(int b= 0; b < 100; b++){
                if(paper[a][b] == 1){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
