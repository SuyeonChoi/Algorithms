package Programmers;


public class ToDescendingOrder {
    public long solution(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
        String s = "";
        for(char c: charArr) {
            s = String.valueOf(c) + s;
        }

        long answer = Long.valueOf(s);
        return answer;
    }
}
