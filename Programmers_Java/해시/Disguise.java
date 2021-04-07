package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Disguise {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }

        int answer = 1;
        for(Integer n : map.values()){
            answer *= n;
        }

        return answer - 1;
    }
}
