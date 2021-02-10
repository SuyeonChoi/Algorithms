import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[] city = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i< N; i++){
                city[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0, ans = 0;
            int flag = city[0];
            for(int i = 0; i < N; i++){
                if(city[i] == 1){
                    flag = 1;
                    cnt = 0;
                    continue;
                }else{ //0인 경우
                    if(flag == 1){ //첫번째 0
                        flag = 0;
                        cnt = 1;
                    }else{ // 연속 0
                        cnt++;
                    }
                }
                if(cnt == D){ //건설
                    flag = 1;
                    cnt = 0;
                    ans++;
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}
