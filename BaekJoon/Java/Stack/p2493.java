import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tower = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && tower[stack.peek()] < tower[i]) stack.pop();
            if (!stack.isEmpty()) {
                sb.append(stack.peek() + 1).append(" ");
            } else sb.append("0 ");
            stack.add(i);
        }

        System.out.println(sb);

    }
}
