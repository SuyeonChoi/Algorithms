package Programmers;

import java.util.Stack;

public class RemovingPair {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.size() == 0) return 1;
        return 0;
    }

}
