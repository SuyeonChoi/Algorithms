package Programmers;

public class MinAndMax {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] number = s.split(" ");
        for (String n: number) {
            int num = Integer.parseInt(n);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        String answer = min + " " + max;
        return answer;
    }
}
