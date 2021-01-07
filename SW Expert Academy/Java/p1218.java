import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int size = Integer.parseInt(br.readLine());
            Character[] paren = new Character[size];
            String str = br.readLine();
            for (int i = 0; i < size; i++) {
                paren[i] = str.charAt(i);
            }
            Stack<Character> stack = new Stack<>();
            int isValid = 1;
            for (Character c : paren) {
                if(c=='(' || c == '[' || c== '{' ||c == '<'){
                    stack.push(c);
                }else if (c == ')'){
                    if(stack.empty() || stack.peek() != '('){
                        isValid = 0;
                        break;
                    }
                    stack.pop();
                }else if (c == ']'){
                    if(stack.empty() || stack.peek() != '['){
                        isValid = 0;
                        break;
                    }
                    stack.pop();
                }else if (c == '}'){
                    if(stack.empty() || stack.peek() != '{'){
                        isValid = 0;
                        break;
                    }
                    stack.pop();
                }else if (c == '>'){
                    if(stack.empty() || stack.peek() != '<'){
                        isValid = 0;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.empty()){
                isValid = 0;
            }

            System.out.println("#" + t + " "+isValid);
        }
    }
}
