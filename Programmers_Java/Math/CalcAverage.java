package Programmers;

public class CalcAverage {
    public double solution(int[] arr) {
        double answer = 0;
        for (int n : arr) {
            answer += n;
        }
        return answer / arr.length;
    }
}
