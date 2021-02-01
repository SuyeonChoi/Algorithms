import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] switches = new int[N];
        for (int i = 0; i < N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if (gender == 1) { //남학생인 경우
                for (int j = idx - 1; j < switches.length; j = j + idx) {
                    if (switches[j] == 1) {
                        switches[j] = 0;
                    } else {
                        switches[j] = 1;
                    }
                }
            } else { //여학생인 경우
                //범위 확인
                int[] range = girlRecursive(switches, idx - 1, idx - 1);
                for (int j = range[0]; j <= range[1]; j++) {
                    if (switches[j] == 1) {
                        switches[j] = 0;
                    } else {
                        switches[j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i != 0 && i % 20 == 0) sb.append("\n");
            sb.append(switches[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] girlRecursive(int[] switches, int st, int en) {
        int[] range = new int[2];
        if (st < 0 || en >= switches.length || switches[st] != switches[en]) {
            range[0] = st + 1;
            range[1] = en - 1;
            return range;
        }
        range = girlRecursive(switches, st - 1, en + 1);
        return range;
    }
}
