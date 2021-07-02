import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
        }

        List<Integer> answerList = new LinkedList<>();
        int before = queue.poll();
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (before >= queue.peek()) {
                cnt++;
                queue.poll();
            } else {
                answerList.add(cnt);
                before = queue.poll();
                cnt = 1;
            }
        }
        answerList.add(cnt);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
