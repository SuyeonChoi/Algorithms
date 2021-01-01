import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);
        int start = 0;
        int end = N-1;
        int ans = 200000000;
        while(start < end){
            int _sum = liquid[start] + liquid[end];
            if(Math.abs(_sum) < Math.abs(ans)){
                ans = _sum;
            }
            if(_sum == 0){
                ans = _sum;
                break;
            } else if(_sum < 0) {
                start += 1;
            }else{
                end -= 1;
            }
    }
        System.out.println(ans);
    }
}
