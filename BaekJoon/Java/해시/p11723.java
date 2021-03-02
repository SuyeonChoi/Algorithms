import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> list = new HashSet<>();
        Set<Integer> allList = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 20; i++){
            allList.add(i);
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("all")){
                list = allList;
                continue;
            }
            if(cmd.equals("empty")){
                list = new HashSet<>();
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            switch (cmd){
                case "add":
                    if(!list.contains(x)) list.add(x);
                    break;
                case "remove":
                    if(list.contains(x)) list.remove((Integer) x);
                    break;
                case "check":
                    if(list.contains(x)) sb.append("1");
                    else sb.append("0");
                    sb.append("\n");
                    break;
                case "toggle":
                    if(list.contains(x)) list.remove((Integer) x);
                    else list.add(x);
                    break;
            }
        }
        System.out.println(sb);
    }
}
