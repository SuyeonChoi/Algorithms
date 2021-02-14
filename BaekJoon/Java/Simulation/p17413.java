import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("")) continue;
            if(str[i].equals("<")){
                while (!str[i].equals(">")){
                    sb.append(str[i]);
                    i++;
                }
                sb.append(">");
                continue;
            }
            else if(str[i].equals(" ")) {
                sb.append(" ");
            }else{
                String tmp = "";
                while(i < str.length && !str[i].equals(" ") && !str[i].equals("<")){
                    tmp = tmp + str[i++];
                }
                sb.append(reverseStr(tmp));
                if(i < str.length && (str[i].equals("<") ||str[i].equals(" "))) i--;
            }
        }
        System.out.println(sb);
    }

    private static String reverseStr(String tmp) {
        return (new StringBuffer(tmp)).reverse().toString();
    }
}
