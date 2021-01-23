import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                stack.add(Integer.parseInt(st.nextToken()));
            }else if(cmd.equals("top")){
                sb.append(stack.peek()).append("\n");
            }else if(cmd.equals("size")){
                sb.append(stack.size()).append("\n");
            }else if(cmd.equals("empty")){
                if(stack.isEmpty()){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }else if(cmd.equals("pop")){
                if(stack.isEmpty()){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(stack.pop().toString()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
