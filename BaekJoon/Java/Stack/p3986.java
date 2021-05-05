package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isGood = true;
            for (char c: word) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
