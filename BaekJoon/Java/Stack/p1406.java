import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : br.readLine().toCharArray()) {
            leftStack.add(c);
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "L":
                    if (! leftStack.isEmpty()) rightStack.add(leftStack.pop());
                    break;
                case "D":
                    if (! rightStack.isEmpty()) leftStack.add(rightStack.pop());
                    break;
                case "B":
                    if (! leftStack.isEmpty()) leftStack.pop();
                    break;
                case "P":
                    char s = st.nextToken().charAt(0);
                    leftStack.add(s);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < leftStack.size(); i++){
            sb.append(leftStack.get(i));
        }
        for(int i =rightStack.size()-1; i >= 0; i--){
            sb.append(rightStack.get(i));
        }
        System.out.println(sb);
    }
}
