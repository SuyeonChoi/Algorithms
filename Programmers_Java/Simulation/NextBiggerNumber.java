package Programmers;

public class NextBiggerNumber {
    public int solution(int n) {
        int one = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') one++;
        }

        for (int i = n + 1; i <= 1000000; i++) {
            int nxtOne = 0;
            for (char c : Integer.toBinaryString(i).toCharArray()) {
                if (c == '1') nxtOne++;
            }
            if (nxtOne == one) return i;
        }
        return -1;
    }
}
