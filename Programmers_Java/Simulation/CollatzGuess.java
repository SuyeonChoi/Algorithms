package Programmers;

public class CollatzGuess {
    public int solution(int num) {
        int answer = 0;
        long N = Long.valueOf(num);

        while (N != 1) {
            if (answer == 500) return -1;
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N *= 3;
                N++;
            }
            answer++;
        }
        return answer;
    }
}
