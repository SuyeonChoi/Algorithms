package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p15662 {
    static List<ArrayList<Integer>> wheels = new ArrayList<>();
    static int[] move;
    static int count;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
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
            move = new int[T];
            moveInfo(wheelNumber - 1, direction);
            moveWheels();
        }
        count = 0;
        calcCnt();
        System.out.println(count);
    }

    private static void moveWheels() {
        for (int i = 0; i < T; i++) {
            if (move[i] == 1) {
                wheels.get(i).add(0, wheels.get(i).remove(wheels.get(i).size() - 1));
            } else if (move[i] == -1) {
                wheels.get(i).add(wheels.get(i).remove(0));
            }
        }
    }

    private static void calcCnt() {
        for (int i = 0; i < T; i++) {
            if (wheels.get(i).get(0) == 1) {
                count++;
            }
        }
    }

    private static void moveInfo(int wheelNumber, int direction) {
        move[wheelNumber] = direction;
        for (int i = wheelNumber + 1; i < T; i++) {
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