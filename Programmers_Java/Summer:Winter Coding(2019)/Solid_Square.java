package Programmers;

public class Solid_Square {
    public long solution(int w, int h) {
        long answer = 0;
        for (int i = 1; i <= h; i++) {
            answer += Math.floor(((double) h - i) * ((double) w / h));
        }

        answer *= 2;
        return answer;
    }
}
