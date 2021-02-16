import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size= (int) Math.pow(2, N);

        System.out.println(DivideAndConquer(N, r, c));
    }

    private static int DivideAndConquer(int n, int r, int c) {
        if(n == 1) return 0;
        int half = n>>1;
        if(r < half && c < half) return DivideAndConquer(half, r, c); // 1사분면
        else if(r < half && c >= half) return DivideAndConquer(half, r, c-half) + half * half; // 2사분면
        else if(r >= half && c < half) return DivideAndConquer(half, r-half, c) + half * half * 2; // 3사분면
        else return DivideAndConquer(half, r - half, c - half) + half * half * 3; //4사분면
    }
}
