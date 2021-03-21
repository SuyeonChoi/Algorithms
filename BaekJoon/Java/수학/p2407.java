package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class p2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        M = Math.min(M, N-M);
        BigDecimal ans = BigDecimal.valueOf(1);
        BigDecimal div = BigDecimal.valueOf(1);
        for(int i = 1; i <= M; i++){
            ans = ans.multiply(BigDecimal.valueOf(N--));
            div = div.multiply(BigDecimal.valueOf(i));
        }
        System.out.println(ans.divide(div));
    }
}
