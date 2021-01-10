import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t < 11; t++){
            int len = Integer.parseInt(br.readLine());
            Stack<String> stack = new Stack<>();
            String[] arr = br.readLine().split("");

            for(int i = 0; i < len; i++){
                if(arr[i].equals("+")) continue;
                if(arr[i].equals("(")){
                    stack.add("(");
                }else if(arr[i].equals(")")){
                    Stack<Integer> stack2 = new Stack<>();
                    while (!stack.peek().equals("(")){
                        if(stack.peek().equals("*")){
                            stack.pop();
                            int a = Integer.parseInt(stack.pop());
                            int b = stack2.pop();
                            stack2.add(a*b);
                        }else{
                            stack2.add(Integer.parseInt(stack.pop()));
                        }
                    }
                    int tmp = 0;
                    while (! stack2.isEmpty()){
                        tmp += (stack2.pop());
                    }
                    stack.pop();
                    stack.add(String.valueOf(tmp));
                }else{
                    stack.add(arr[i]);
                }
            }
            int ans = 0;
            Stack<Integer> stack2 = new Stack<>();
            for(int i = 0; i < stack.size(); i++){
                if(stack.peek().equals("*")){
                    stack.pop();
                    int a = Integer.parseInt(stack.pop());
                    int b = stack2.pop();
                    stack2.add(a*b);
                }else{
                    stack2.add(Integer.parseInt(stack.pop()));
                }
            }
            while (! stack2.isEmpty()){
                ans += (stack2.pop());
            }
            System.out.println("#" + t + " "+ans);
        }
    }
}
