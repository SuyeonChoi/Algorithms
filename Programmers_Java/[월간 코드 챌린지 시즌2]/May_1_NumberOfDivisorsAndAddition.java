package Programmers;

public class May_1_NumberOfDivisorsAndAddition {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int divisor = divisorCnt(i);

            if (divisor % 2 == 0) {
                answer += i;
            }else {
                answer -= i;
            }
        }
        return answer;
    }

    private int divisorCnt(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
