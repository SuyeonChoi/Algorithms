import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1158_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder("<");
        int idx = K - 1;
        while (!list.isEmpty()) {
            while (idx >= list.size()) idx -= list.size();
            sb.append(list.remove(idx));
            if (!list.isEmpty()) sb.append(", ");
            idx += (K-1);
        }
        System.out.println(sb.append(">"));
    }
}
