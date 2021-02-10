import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] bus = new int[N][2];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                bus[i][0] = Integer.parseInt(st.nextToken());
                bus[i][1] = Integer.parseInt(st.nextToken());
            }
            int P = Integer.parseInt(br.readLine());
            int[] station = new int[P];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < P; i++){
                int num = Integer.parseInt(br.readLine());
                int cnt = 0;
                for(int j = 0; j < N; j++){
                    if(bus[j][0] <= num && num <= bus[j][1]) cnt++;
                }
                sb.append(cnt+" ");
            }

            System.out.print("#"+t+" ");
            System.out.println(sb);
        }
    }
}
