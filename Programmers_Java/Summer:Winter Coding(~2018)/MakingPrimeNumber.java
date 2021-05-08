package Programmers;

public class MakingPrimeNumber {
    static int[] numbers;
    static int[] inputs;
    static int N;
    static int answer;

    public int solution(int[] nums) {
        N = nums.length;
        numbers = new int[3];
        inputs = nums;

        answer = 0;
        combination(0, 0);

        return answer;
    }

    private void combination(int cnt, int start) {
        if (cnt == 3) {
            if (isPrime()) {
                answer++;
            }
        } else {
            for (int i = start; i < N; i++) {
                numbers[cnt] = inputs[i];
                combination(cnt + 1, i + 1);
            }
        }
    }

    private boolean isPrime() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += numbers[i];
        }
        for (int i = 2; i <= sum-1; i++) {
            if (sum % i == 0) return false;
        }
        return true;
    }
}