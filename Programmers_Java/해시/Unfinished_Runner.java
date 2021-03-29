package Programmers;

import java.util.HashMap;

public class Unfinished_Runner {

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0){
                map.remove(c);
            }
        }
        String answer = "";
        for(String s: map.keySet()){
            if(map.get(s) != 0){
              answer = s;
            }
        }
        return answer;
    }
}
