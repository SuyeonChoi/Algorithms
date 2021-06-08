package Programmers;

public class Find_Mr_Kim {
    public String solution(String[] seoul) {
        int i;
        for (i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) break;
        }
        String answer = "김서방은 " + i + "에 있다";
        return answer;
    }
}
