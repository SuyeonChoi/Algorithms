import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        char[] arr = new char[N1+N2];
        char[] antGroup = br.readLine().toCharArray();
        System.arraycopy(antGroup, 0, arr, 0, N1);
        antGroup = br.readLine().toCharArray();
        System.arraycopy(antGroup, 0, arr, N1, N2);
        System.out.println(Arrays.toString(arr));
        int T = Integer.parseInt(br.readLine());
        int cnt = 0; //자리 바꾼 횟수
        int switchN1 = N1 - 1;
        for(int t = 0; t < T; t++){
            if(Math.min(N1, N2) >= cnt) break;
            for(int i = switchN1; i < N1 + N2; i++){
                swap(arr, switchN1);
            }
            cnt++;
        }
        for(int i = 0; i < N1+N2; i++){
            System.out.print(arr[i]);
        }
    }

    private static void swap(char[] arr, int jumpIdx) {

    }
}
