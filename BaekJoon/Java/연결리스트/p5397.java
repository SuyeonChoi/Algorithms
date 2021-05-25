package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            int cursor = 0;
            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (cursor == 0) continue;
                    cursor--;
                } else if (c == '>') {
                    if (cursor == list.size()) continue;
                    cursor++;
                } else if (c == '-') {
                    if (cursor == 0) continue;
                    list.remove(cursor - 1);
                    if (cursor != 0) cursor--;
                } else {
                    list.add(cursor, c);
                    cursor++;
                }
            }

            sb.append(listToString(list)).append("\n");
        }
        System.out.println(sb);
    }

    private static String listToString(LinkedList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
