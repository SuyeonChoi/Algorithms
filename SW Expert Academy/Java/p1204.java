import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1204 {
    public static int findMaxIndex(int[] arr){
        int max = arr[0];
        int idx = 0;
        for(int i = 0; i < 1000; i++){
            if(max <= arr[i]){
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int idx = Integer.parseInt(br.readLine());
            int[] students = new int[1000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 1000; j++){
                int score = Integer.parseInt(st.nextToken());
                students[score] += 1;
            }
            System.out.println("#"+idx+" "+findMaxIndex(students));
        }
    }
}

