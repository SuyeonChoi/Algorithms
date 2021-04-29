package Programmers;

import java.util.PriorityQueue;

public class More_Hotter {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        int hotDegree = 0;
        int answer = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + (second * 2));

            answer++;
        }

        if (pq.isEmpty()) answer = -1;
        return answer;
    }
}
