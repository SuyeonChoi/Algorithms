package Programmers;

import java.util.*;

public class season2_april_2 {
    public int solution(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            queue.offerLast(c);
        }

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            queue.offerLast(queue.pollFirst());
            if (isPair(queue)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPair(Deque<Character> queue) {
        Stack<Character> stack = new Stack<>();
        for (Character c : queue) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

}
