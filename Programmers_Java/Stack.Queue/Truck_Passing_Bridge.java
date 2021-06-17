package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Truck_Passing_Bridge {
    static class Truck {
        int w;
        int t;

        public Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
//        solution(2, 10, new int[] {7, 4, 5, 6});
//        solution(5, 5, new int[] {2, 2, 2, 2, 1, 1, 1, 1, 1});
//        solution(5, 5, new int[] {2, 2, 2, 2, 1, 1, 1, 1, 1});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck> queue = new ArrayDeque<>();
        int idx = 0;
        int curWeight = 0;
        int time = 0;
        while (idx < truck_weights.length || !queue.isEmpty()) {
            int tmpTime = 0;
            while (idx < truck_weights.length && (curWeight + truck_weights[idx]) <= weight && queue.size() < bridge_length) {
                if (!queue.isEmpty()) {
                    if (queue.peekLast().t >= time + tmpTime ) break;
                }
                curWeight += truck_weights[idx];
                queue.offerLast(new Truck(truck_weights[idx], time + tmpTime));
                tmpTime++;
                idx++;
            }

            Truck outTruck = queue.pollFirst();
            int outTime = outTruck.t + bridge_length - time;
            time += outTime;
            curWeight -= outTruck.w;

        }
        System.out.println(time + 1);
        return time + 1;
    }
}
