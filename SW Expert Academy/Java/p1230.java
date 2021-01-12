import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1230 {
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
                int x, y, s;
                switch (cmd) {
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            s = Integer.parseInt(st.nextToken());
                            code.add(x + j, s);
                        }
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            code.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0; j < y; j++){
                            code.add(Integer.parseInt(st.nextToken()));
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
