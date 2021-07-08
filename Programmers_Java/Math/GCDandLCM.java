package Programmers;

public class GCDandLCM {
    public int[] solution(int n, int m) {
        int gcd;
        int lcm;

        for (gcd = Math.min(n, m); gcd > 0; gcd--) {
            if (n % gcd == 0 && m % gcd == 0) break;
        }

        for (lcm = Math.max(n, m); ; lcm++) {
            if (lcm % n == 0 && lcm % m == 0) break;
        }
        return new int[]{gcd, lcm};
    }
}
