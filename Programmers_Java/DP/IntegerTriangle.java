package Programmers;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][];
        for (int i = 0; i < N; i++) {
            dp[i] = new int[triangle[i].length];
            if (i == 0) {
                dp[0][0] = triangle[0][0];
                continue;
            }
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + triangle[i][0];
                } else if (j == dp[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for (int n : dp[N - 1]) {
            answer = Math.max(n, answer);
        }
        return answer;
    }
}
