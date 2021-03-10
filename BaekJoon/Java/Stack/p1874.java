import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            while (arr[i] >= num){
                stack.add(num++);
                sb.append('+').append('\n');
            }
            if(stack.peek() == arr[i]){
                stack.pop();
                sb.append('-').append('\n');
            }else if(stack.peek() > arr[i]){
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}
