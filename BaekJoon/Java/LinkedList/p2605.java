import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> line = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        line.add(1);
        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            line.add(line.size() - num, i+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(line.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
