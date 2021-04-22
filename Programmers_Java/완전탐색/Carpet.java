package Programmers;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int N = brown + yellow;
        for (int c = 3; c < N / 2; c++) {
            if (N % c != 0) continue;
            int r = N / c;
            if (((2 * c) + 2 * (r - 2)) == brown && ((r - 2) * (c - 2)) == yellow) {
                answer[0] = r;
                answer[1] = c;
                break;
            }
        }
        return answer;
    }
}
