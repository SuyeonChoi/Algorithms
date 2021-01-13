import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1232 {
    static int[] lc;
    static int[] rc;
    static String[] alp;
    static LinkedList<String> exp = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            lc = new int[N + 1];
            rc = new int[N + 1];
            alp = new String[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                alp[u] = st.nextToken();
                if (st.hasMoreTokens()) {
                    lc[u] = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    rc[u] = Integer.parseInt(st.nextToken());
                }
            }
            inorder(1);
            Stack<String> stack = new Stack<>();
            for(int i = 0; i < exp.size(); i++){
                if(exp.get(i).equals(")")){
                    int num2 = Integer.parseInt(stack.pop());
                    String op = stack.pop();
                    int num1 = Integer.parseInt(stack.pop());
                    stack.pop();
                    if(op.equals("+")) stack.add(String.valueOf(num1 + num2));
                    else if(op.equals("-")) stack.add(String.valueOf(num1 - num2));
                    else if(op.equals("*")) stack.add(String.valueOf(num1 * num2));
                    else if(op.equals("/")) stack.add(String.valueOf(num1 / num2));
                }else{
                    stack.add(exp.get(i));
                }
            }
            System.out.println("#" + t + " " + stack.pop());
        }
    }

    private static void inorder(int cur) {
        if (lc[cur] != 0){
            exp.add("(");
            inorder(lc[cur]);
        }
        exp.add(alp[cur]);
        if (rc[cur] != 0) {
            inorder(rc[cur]);
            exp.add(")");
        }
    }
}
