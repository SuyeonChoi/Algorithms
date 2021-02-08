import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5215 {
    static int[] scores;
    static int[] calories;
    static boolean[] isSelected;
    static int N;
    static int L;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            max = 0;
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            scores = new int[N];
            calories = new int[N];
            isSelected = new boolean[N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            powerSet(0, 0, 0);

            System.out.println("#"+t+" "+ max);
        }
    }

    private static void powerSet(int cnt, int scoreSum, int calSum) {
        if(cnt == N){
            if(calSum < L && scoreSum > max) {
                max = scoreSum;
            }
        }else{
            isSelected[cnt] = true;
            powerSet(cnt+1, scoreSum+scores[cnt], calSum+calories[cnt]);
            isSelected[cnt] = false;
            powerSet(cnt+1,scoreSum, calSum);
        }
    }
}
