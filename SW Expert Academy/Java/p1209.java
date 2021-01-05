import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t < 11; t++){
            int idx = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j ++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int rowMax = findInRow(arr);
            int colMax = findInCol(arr);
            int diaMax = findInDia(arr);

            System.out.println("#"+idx+" "+Math.max(Math.max(rowMax, colMax), diaMax));

        }
    }

    private static int findInRow(int[][] arr) {
        int sum = 0;
        for(int i = 0; i < 100; i++){
            int rowSum = 0;
            for (int j = 0; j < 100; j ++){
                rowSum += arr[i][j];
            }
            if(rowSum > sum){
                sum = rowSum;
            }
        }
        return sum;
    }

    private static int findInCol(int[][] arr) {
        int sum = 0;
        for(int i = 0; i < 100; i++){
            int colSum = 0;
            for (int j = 0; j < 100; j ++){
                colSum += arr[j][i];
            }
            if(colSum > sum){
                sum = colSum;
            }
        }
        return sum;
    }

    private static int findInDia(int[][] arr) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < 100; i++) {
            left += arr[i][i];
            right += arr[99 - i][99 - i];
        }
        return Math.max(left, right);
    }

}
