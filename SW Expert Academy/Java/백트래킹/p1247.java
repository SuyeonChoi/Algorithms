import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1247 {
    static int N;
    static int comX, comY, homeX, homeY;
    static int[][] customers;
    static int[] index;
    static boolean[] isSelected;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            customers = new int[N][2];
            index = new int[N];
            isSelected = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            comX = Integer.parseInt(st.nextToken());
            comY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            for(int i = 0; i < N; i++){
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
                index[i] = i;
            }
            //방문하는 모든 경우의수 - 순열
            visitCustomers(0);
            System.out.println("#"+t+" "+ min);
        }

    }

    private static void visitCustomers(int cnt) {
        if(cnt == N){
            //경로 생성됨
            int len = Math.abs(comX - customers[index[0]][0]) + Math.abs(comY - customers[index[0]][1]);
            for(int i = 1; i < N; i++){
                len += (Math.abs(customers[index[i-1]][0] - customers[index[i]][0]) + Math.abs(customers[index[i-1]][1] - customers[index[i]][1]));
            }
            len += (Math.abs(homeX - customers[index[N-1]][0]) + Math.abs(homeY - customers[index[N-1]][1]));
            if(len < min){
                min = len;
            }
        }
        for(int i = 0;i < N; i++){
            if(isSelected[i]) continue;
            index[cnt] = i;
            isSelected[i] = true;
            visitCustomers(cnt+1);
            isSelected[i] = false;
        }
    }
}
