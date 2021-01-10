import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t < 11; t++){
            int len = Integer.parseInt(br.readLine());
            int[][] table = new int[100][100];
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //테이블을 탐색하며 떨어뜨리기
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    if(table[i][j] == 1){
                        table = moveN(table, i, j);
                    }else if(table[i][j] == 2){
                        table = moveS(table, i, j);
                    }
                }
            }
            //교착상태 개수 구하기
            int ans = 0;
            int[][] vis = new int[100][100];
            for(int j = 0; j < 100; j++){
                for(int i = 0; i < 100; i++){
                    if(table[i][j] != 0){
                        ans += 1;
                        vis[i][j] = 1;
                        int pole = table[++i][j];
                        vis[i][j] = 1;
                        while(pole == table[i][j] && vis[i][j] == 0){
                            i++;
                            vis[i][j] = 1;
                            if(i >= 100) break;
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }

    private static int[][] moveS(int[][] table, int i, int j) {
        table[i][j] = 0;
        while(table[i][j] != 1){
            i--;
            if(i < 0){
                break;
            }
        }
        if(i >= 0){
            table[i+1][j] = 2;
        }
        return table;
    }

    private static int[][] moveN(int[][] table, int i, int j) {
        table[i][j] = 0;
        while(table[i][j] != 2){
            i++;
            if(i >= 100){
                break;
            }
        }
        if(i < 100){
            table[i-1][j] = 1;
        }
        return table;
    }
}
