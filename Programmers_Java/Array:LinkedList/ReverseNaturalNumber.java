package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseNaturalNumber {
    public int[] solution(long n) {
        List<Integer> arrList = new ArrayList<>();
        for (String s : String.valueOf(n).split("")) {
            arrList.add(Integer.parseInt(s));
        }
        Collections.reverse(arrList);
        int[] answer = new int[arrList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}
