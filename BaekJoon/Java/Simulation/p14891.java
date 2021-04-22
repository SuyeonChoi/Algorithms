package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p14891 {
    static List<Integer> wheelA = new ArrayList<>();
    static List<Integer> wheelB = new ArrayList<>();
    static List<Integer> wheelC = new ArrayList<>();
    static List<Integer> wheelD = new ArrayList<>();
    static int[] move;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] wheel_a = br.readLine().toCharArray();
        char[] wheel_b = br.readLine().toCharArray();
        char[] wheel_c = br.readLine().toCharArray();
        char[] wheel_d = br.readLine().toCharArray();
        for (int i = 0; i < 8; i++) {
            wheelA.add(wheel_a[i] - '0');
            wheelB.add(wheel_b[i] - '0');
            wheelC.add(wheel_c[i] - '0');
            wheelD.add(wheel_d[i] - '0');
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNumber = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            move = new int[4];
            moveInfo(wheelNumber, direction);
            switch (wheelNumber) {
                case 1:
                    moveA(direction);
                    break;
                case 2:
                    moveB(direction);
                    break;
                case 3:
                    moveC(direction);
                    break;
                case 4:
                    moveD(direction);
                    break;
            }
            moveWheels();
        }
        score = 0;
        calcScore();
        System.out.println(score);
    }



    private static void moveWheels() {
        if (move[0] == 1) {
            wheelA.add(0, wheelA.remove(wheelA.size() - 1));
        } else if (move[0] == -1) {
            wheelA.add(wheelA.remove(0));
        }
        if (move[1] == 1) {
            wheelB.add(0, wheelB.remove(wheelB.size() - 1));
        } else if (move[1] == -1) {
            wheelB.add(wheelB.remove(0));
        }
        if (move[2] == 1) {
            wheelC.add(0, wheelC.remove(wheelC.size() - 1));
        } else if (move[2] == -1) {
            wheelC.add(wheelC.remove(0));
        }
        if (move[3] == 1) {
            wheelD.add(0, wheelD.remove(wheelD.size() - 1));
        } else if (move[3] == -1) {
            wheelD.add(wheelD.remove(0));
        }
    }

    private static void calcScore() {
        if (wheelA.get(0) == 1) {
            score++;
        }
        if (wheelB.get(0) == 1) {
            score += 2;
        }
        if (wheelC.get(0) == 1) {
            score += 4;
        }
        if (wheelD.get(0) == 1) {
            score += 8;
        }
    }

    private static void moveA(int direction) {
        move[0] = direction;
        if (wheelA.get(2) != wheelB.get(6)) {
            move[1] = -direction;
        }
        if (wheelB.get(2) != wheelC.get(6)) {
            move[2] = -move[1];
        }
        if (wheelC.get(2) != wheelD.get(6)) {
            move[3] = -move[2];
        }
    }

    private static void moveInfo(int wheelNumber, int direction) {
        move[wheelNumber] = direction;


    }

    private static void moveB(int direction) {
        move[1] = direction;
        if (wheelA.get(2) != wheelB.get(6)) {
            move[0] = -direction;
        }
        if (wheelB.get(2) != wheelC.get(6)) {
            move[2] = -move[1];
        }
        if (wheelC.get(2) != wheelD.get(6)) {
            move[3] = -move[2];
        }
    }

    private static void moveC(int direction) {
        move[2] = direction;
        if (wheelB.get(2) != wheelC.get(6)) {
            move[1] = -move[2];
        }
        if (wheelA.get(2) != wheelB.get(6)) {
            move[0] = -move[1];
        }
        if (wheelC.get(2) != wheelD.get(6)) {
            move[3] = -move[2];
        }
    }

    private static void moveD(int direction) {
        move[3] = direction;
        if (wheelC.get(2) != wheelD.get(6)) {
            move[2] = -move[3];
        }
        if (wheelB.get(2) != wheelC.get(6)) {
            move[1] = -move[2];
        }
        if (wheelA.get(2) != wheelB.get(6)) {
            move[0] = -move[1];
        }
    }
}
