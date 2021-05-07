package Programmers;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        String number = "";
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<ArrayList<String>> tuple = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '{') {
                numbers = new ArrayList<>();
                number = "";
            } else if (c == '}') {
                numbers.add(number);
                tuple.add(numbers);
            } else if (c == ',') {
                if (s.charAt(i - 1) == '}') continue;
                numbers.add(number);
                number = "";
            } else {
                number += c;
            }
        }

        Collections.sort(tuple, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.size() - o2.size();
            }
        });

        int[] answer = new int[tuple.size()];
        Set<String> tupleSet = new HashSet<>();
        for(int i = 0; i < tuple.size(); i++) {
            for (String num : tuple.get(i)) {
                if (tupleSet.contains(num)) continue;
                else {
                    tupleSet.add(num);
                    answer[i] = Integer.parseInt(num);
                    break;
                }
            }
        }

        for (int i = 0; i < tuple.size(); i++) {
            System.out.println(tuple.get(i));
        }
        return answer;
    }
}