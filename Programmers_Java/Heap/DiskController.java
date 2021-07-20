package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class DiskController {
    static class Disk implements Comparable<Disk> {
        int left; //남은 시간
        int time;
        int start;

        public Disk(int left, int time, int start) {
            this.left = left;
            this.time = time;
            this.start = start;
        }

        @Override
        public int compareTo(Disk o) {
            if (this.left == o.left) {
                return this.time - o.time;
            }
            return this.left - o.left;
        }
    }

    public static void main(String[] args) {
        solution(new int[][]{{0, 3}, {1, 6}, {2, 9}});
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        for (int[] j : jobs) {
            pq.add(new Disk(j[0], j[1], j[0]));
        }

        int answer = 0;
        int time = pq.peek().start;
        while (!pq.isEmpty()) {
            Disk cur = pq.poll();
            answer += (cur.time + (time - cur.start)); // 처리시간 + 대기 시간
            time += (cur.time + cur.left); // 현재 진행 시간 + 남은 시간
            for (Disk disk : pq) {
                if (disk.start <= time) {
                    disk.left = 0;
                } else {
                    disk.left = disk.start - time;
                }
            }
        }
        System.out.println(answer);
        return answer / jobs.length;
    }
}
