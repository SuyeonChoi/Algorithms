import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t < 11; t++){
            String[] str = br.readLine().split(" ");
            int total = Integer.parseInt(str[0]);
            int[] numList = new int[total];
            String[] numStr = str[1].split("");
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            for(int i = 0; i < total; i++){
                stack1.add(Integer.parseInt(numStr[i]));
            }

            while (! stack1.isEmpty()){
                if(!stack2.isEmpty() && stack1.peek() == stack2.peek()) {
                    stack1.pop();
                    stack2.pop();
                }else{
                    stack2.add(stack1.pop());
                }
            }
            String ans = "";
            while (!stack2.isEmpty()){
                ans += stack2.pop();
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}
