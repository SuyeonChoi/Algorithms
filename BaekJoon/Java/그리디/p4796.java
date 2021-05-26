package Algorithms;

import java.util.Scanner;

public class p4796 {
    static int l,p,v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while (true) {
            l = sc.nextInt();
            p = sc.nextInt();
            v = sc.nextInt();
            // 0이 들어오면 종료
            if (l == 0) break;
            int result = 0;
            for (int i = 0; i < v; ) {
                result += l;
                i += l;
                if (i >= v) result -= i - v;
                i += p - l;
            }
            System.out.println("Case " + tc + ": " + result);
            tc++;
        }
    }
}
