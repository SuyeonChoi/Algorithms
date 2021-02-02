import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 1;
            int[][] arr = new int[N][N];
            int curX = 0, curY = 0;
            char dir = 'R';
            while(cnt <= N*N){
                arr[curX][curY] = cnt++;
                switch (dir){
                    case 'R':
                        if(curY+1 >= N || arr[curX][curY+1] != 0){
                            dir = 'D';
                            curX++;
                        }
                        else curY++;
                        break;
                    case 'L':
                        if(curY-1 < 0 || arr[curX][curY-1] != 0){
                            dir = 'U';
                            curX--;
                        }
                        else curY--;
                        break;
                    case 'U':
                        if(curX-1 < 0 || arr[curX-1][curY] != 0){
                            dir = 'R';
                            curY++;
                        }else curX--;
                        break;
                    case 'D':
                        if(curX+1 >= N || arr[curX+1][curY] != 0){
                            dir = 'L';
                            curY--;
                        }else curX++;
                        break;
                }
            }
            System.out.println("#"+ t);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

}
