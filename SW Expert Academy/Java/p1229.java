import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> code = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                code.add(Integer.parseInt(st.nextToken()));
            }
            int C = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < C; i++) {
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case "I":
                        for (int j = 0; j < y; j++) {
                            int s = Integer.parseInt(st.nextToken());
                            code.add(x + j, s);
                        }
                        break;
                    case "D":
                        for (int j = 0; j < y; j++) {
                            code.remove(x);
                        }
                        break;
                }

            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(code.get(i) + " ");
            }
            System.out.println();
        }

    }
}
