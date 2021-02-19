import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[i][2] = dir;
            int x, y;
            switch (dir) {
                case 1: //north
                    arr[i][0] = dist;
                    arr[i][1] = R;
                    break;
                case 2: //south
                    arr[i][0] = dist;
                    arr[i][1] = 0;
                    break;
                case 3: //west
                    arr[i][0] = 0;
                    arr[i][1] = R - dist;
                    break;
                case 4: //east
                    arr[i][0] = C;
                    arr[i][1] = R - dist;
                    break;
            }
        }
        int minDist = 0;
        for (int i = 0; i < N; i++) {
            if ((arr[N][2] == 1 && arr[i][2] == 2) || (arr[N][2] == 2 && arr[i][2] == 1)) { //동근이와 행 기준 수평
                minDist += R;
                minDist += Math.min(arr[i][0]+ arr[N][0], C - arr[i][0]+ C - arr[N][0]);
            } else if ((arr[N][2] == 3 && arr[i][2] == 4) || (arr[N][2] == 4 && arr[i][2] == 3)) {
                minDist += C;
                minDist += Math.min(arr[i][1] + arr[N][1], (R - arr[i][1]) + (R - arr[N][1]));
            } else { // 90도 차
                minDist += (Math.abs(arr[i][0] - arr[N][0]) + Math.abs(arr[i][1] - arr[N][1]));
            }
        }
        System.out.println(minDist);
    }
}
