package Programmers;

public class NumberExpression {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = i;
            for (int j = i + 1; j <= n; j++) {
                if (tmp == n) {
                    answer++;
                    break;
                }
                if (tmp > n) break;
                tmp += j;
            }
        }
        return answer + 1;
    }
}
