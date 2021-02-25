import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] cake = new int[L+1];
        int max = 0;
        int idx = 0;
        int practicalMax = 0;
        int practicalIdx = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = end - start + 1;
            if(max < len){
                max = len;
                idx = i+1;
            }
            int tmp = 0;
            for(int j = start; j <= end; j++){
                if(cake[j] == 0){
                    cake[j] = i+1;
                    tmp++;
                }
            }
            if(tmp > practicalMax){
                practicalMax = tmp;
                practicalIdx = i+1;
            }
        }
        System.out.println(idx);
        System.out.println(practicalIdx);
    }
}
