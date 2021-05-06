package Programmers;

import java.util.ArrayList;
import java.util.Stack;

public class MaximizingFormula {
    static ArrayList<Integer> operand = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();
    static ArrayList<String> formula = new ArrayList<>();
    static char[] operators = {'+', '-', '*'};
    static Long max = 0L;
    static int N;
    static int R;
    static boolean[] isSelected = new boolean[3];
    static char[] sequence = new char[3];

    public static void main(String[] args) {
        solution("50*6-3*2");
    }

    public static long solution(String expression) {
        String number = "";
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operator.add(c);
                operand.add(Integer.parseInt(number));
                formula.add(number);
                formula.add(Character.toString(c));
                number = "";
            } else {
                number += c;
            }
        }
        operand.add(Integer.parseInt(number));
        formula.add(number);
        R = operator.size();
        permutation(0);

        return max;
    }

    private static void permutation(int cnt) {
        if (cnt == 3) {
            Long result = Long.parseLong(calculate());
            if (result < 0) {
                result = -(result);
            }
            max = Math.max(result, max);
        } else {
            for (int i = 0; i < 3; i++) {
                if (isSelected[i]) continue;
                isSelected[i] = true;
                sequence[cnt] = operators[i];
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    private static String calculate() {
        Stack<String> stack = new Stack<>();
        // 첫번째 우선순위 계산
        for (int i = 0; i < formula.size(); i++) {
            char c = formula.get(i).charAt(0);
            if (c == sequence[0]) {
                stack.push(calcTwoNumbers(Long.parseLong(stack.pop()), Long.parseLong(formula.get(i + 1)), sequence[0]));
                i++;
            } else {
                stack.push(formula.get(i));
            }
        }
        // 두번째
        if (stack.size() == 1) return stack.pop();
        ArrayList<String> temp = new ArrayList<>();
        while (!stack.isEmpty()) {
            temp.add(0, stack.pop());
        }
        for (int i = 0; i < temp.size(); i++) {
            char c = temp.get(i).charAt(0);
            if (c == sequence[1]) {
                stack.push(calcTwoNumbers(Long.parseLong(stack.pop()), Long.parseLong(temp.get(i + 1)), sequence[1]));
                i++;
            } else {
                stack.push(temp.get(i));
            }
        }

        // 세번째
        if (stack.size() == 1) return stack.pop();
        temp.clear();
        while (!stack.isEmpty()) {
            temp.add(0, stack.pop());
        }
        for (int i = 0; i < temp.size(); i++) {
            char c = temp.get(i).charAt(0);
            if (c == sequence[2]) {
                stack.push(calcTwoNumbers(Long.parseLong(stack.pop()), Long.parseLong(temp.get(i + 1)), sequence[2]));
                i++;
            } else {
                stack.push(temp.get(i));
            }
        }
        return stack.pop();
    }

    private static String calcTwoNumbers(Long a, Long b, char c) {
        if (c == '+') {
            return String.valueOf(a + b);
        } else if (c == '-') {
            return String.valueOf(a - b);
        } else {
            return String.valueOf(a * b);
        }
    }
}
