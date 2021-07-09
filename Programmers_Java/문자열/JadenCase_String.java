package Programmers;

public class JadenCase_String {
    public String solution(String s) {
        String[] str = s.split(" ");

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String[] word = str[i].split("");
            for (int j = 0; j < word.length; j++) {
                if (j == 0) {
                    answer.append(word[j].toUpperCase());
                } else {
                    answer.append(word[j].toLowerCase());
                }
            }
            if (i == str.length - 1) break;
            answer.append(" ");
        }
        if (answer.toString().length() != s.length()) {
            answer.append(" ");
        }
        return answer.toString();
    }
}
