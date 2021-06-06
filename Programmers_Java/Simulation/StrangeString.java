package Programmers;

public class StrangeString {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
                idx = 0;
                continue;
            }
            if(idx % 2 == 0) {
                answer += String.valueOf(s.charAt(i)).toUpperCase();
            }else {
                answer += String.valueOf(s.charAt(i)).toLowerCase();
            }
            idx++;
        }
        return answer;
    }
}
