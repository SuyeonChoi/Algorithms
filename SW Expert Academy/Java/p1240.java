import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //암호문 찾기
            int x = -1, y = -1;
            String[] code = null;
            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split("");
                if (x != -1) continue;
                for (int j = M - 1; j >= 0; j--) {
                    if (str[j].equals("1")) {
                        x = i;
                        y = j;
                        code = str;
                        break;
                    }
                }
            }

            //암호문 해독
            String[] zero = {"0", "0", "0", "1", "1", "0", "1"};
            String[] one = {"0", "0", "1", "1", "0", "0", "1"};
            String[] two = {"0", "0", "1", "0", "0", "1", "1"};
            String[] three = {"0", "1", "1", "1", "1", "0", "1"};
            String[] four = {"0", "1", "0", "0", "0", "1", "1"};
            String[] five = {"0", "1", "1", "0", "0", "0", "1"};
            String[] six = {"0", "1", "0", "1", "1", "1", "1"};
            String[] seven = {"0", "1", "1", "1", "0", "1", "1"};
            String[] eight = {"0", "1", "1", "0", "1", "1", "1"};
            String[] nine = {"0", "0", "0", "1", "0", "1", "1"};
            int cnt = 0;
            String tmpCode = "";
            code = Arrays.copyOfRange(code, y - 56 + 1, y + 1);
            while (cnt < 56) {
                String[] tmp = Arrays.copyOfRange(code, cnt, cnt + 7);
                cnt += 7;
                if (Arrays.equals(zero, tmp)) tmpCode += "0";
                else if (Arrays.equals(one, tmp)) tmpCode += "1";
                else if (Arrays.equals(two, tmp)) tmpCode += "2";
                else if (Arrays.equals(three, tmp)) tmpCode += "3";
                else if (Arrays.equals(four, tmp)) tmpCode += "4";
                else if (Arrays.equals(five, tmp)) tmpCode += "5";
                else if (Arrays.equals(six, tmp)) tmpCode += "6";
                else if (Arrays.equals(seven, tmp)) tmpCode += "7";
                else if (Arrays.equals(eight, tmp)) tmpCode += "8";
                else if (Arrays.equals(nine, tmp)) tmpCode += "9";
            }
            String[] last = tmpCode.split("");
            int odd = 0;
            int even = 0;
            int sum = 0;
            for (int i = 0; i < last.length - 1; i++) {
                if ((i + 1) % 2 == 0) even += Integer.parseInt(last[i]);
                else odd += Integer.parseInt(last[i]);
                sum += Integer.parseInt(last[i]);
            }
            if ((odd * 3 + even + Integer.parseInt(last[7])) % 10 != 0) {
                System.out.println("#" + t + " " + 0);
            }else{
                System.out.println("#" + t + " " + (sum+Integer.parseInt(last[7])));
            }


        }
    }

}
