import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int len = Integer.parseInt(br.readLine());
            String[] exp = br.readLine().split("");
            Stack<Integer> stack = new Stack<>();
            stack.add(Integer.parseInt(exp[0]));
            for (int i = 1; i < len; i++) {
                if (exp[i].equals("+") || exp[i].equals("*")) {
                    continue;
                } else if(exp[i-1].equals("*")){
                    int a = stack.pop();
                    int b = Integer.parseInt(exp[i]);
                    stack.add(a*b);
                }else{
                    stack.add(Integer.parseInt(exp[i]));
                }
            }
            int ans = 0;
            while (!stack.isEmpty()){
                ans += (stack.pop());
            }
            System.out.println("#" + t +" "+ ans);
        }
    }
}
