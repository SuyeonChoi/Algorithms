package Programmers;

import java.util.ArrayList;
import java.util.Stack;

public class ClawCraneGame {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        ArrayList<ArrayList<Integer>> boardList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            boardList.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 0) continue;
                boardList.get(i).add(board[j][i]);
            }
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int m : moves) {
            if (boardList.get(m-1).size() == 0) continue;
            int doll = boardList.get(m - 1).remove(0);
            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                cnt += 2;
            } else {
                stack.push(doll);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(boardList.get(i));
        }
        return cnt;
    }
}
