package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Biggest_Number {
    public static void main(String[] args) {
        int[] arr = {6, 10, 2};
        solution(arr);
    }

    public static String solution(int[] numbers) {
        Integer[] number = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            number[i] = numbers[i];
        }

        Arrays.sort(number, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1.toString() + o2.toString();
                String str2 = o2.toString() + o1.toString();
                if (str1.equals(str2))
                    return 0;
                else if (Integer.parseInt(str1) > Integer.parseInt(str2))
                    return -1;
                else
                    return 1;
            }
        });
        StringBuilder answer = new StringBuilder();
        for(Integer i: number){
            answer.append(i);
        }
        if (answer.toString().charAt(0) == '0') return "0";
        return answer.toString();
    }

}
