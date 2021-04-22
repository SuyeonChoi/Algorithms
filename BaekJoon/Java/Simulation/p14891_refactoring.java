package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p14891_refactoring {
    static List<ArrayList<Integer>> wheels = new ArrayList<>();
    static int[] move;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String wheel = br.readLine();
            wheels.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                wheels.get(i).add(wheel.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNumber = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            move = new int[4];
            moveInfo(wheelNumber - 1, direction);
            moveWheels();
        }
        score = 0;
        calcScore();
        System.out.println(score);
    }

    private static void moveWheels() {
        for (int i = 0; i < 4; i++) {
            if (move[i] == 1) {
                wheels.get(i).add(0, wheels.get(i).remove(wheels.get(i).size() - 1));
            } else if (move[i] == -1) {
                wheels.get(i).add(wheels.get(i).remove(0));
            }
        }
    }

    private static void calcScore() {
        for (int i = 0; i < 4; i++) {
            if (wheels.get(i).get(0) == 1) {
                score += (Math.pow(2, i));
            }
        }
    }

    private static void moveInfo(int wheelNumber, int direction) {
        move[wheelNumber] = direction;
        for (int i = wheelNumber + 1; i < 4; i++) {
            if (wheels.get(i).get(6) != wheels.get(i - 1).get(2)) {
                move[i] = -move[i - 1];
            }
        }
        for (int i = wheelNumber - 1; i >= 0; i--) {
            if (wheels.get(i).get(2) != wheels.get(i + 1).get(6)) {
                move[i] = -move[i + 1];
            }
        }
    }
}
