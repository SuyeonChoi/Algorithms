import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] numArray = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        ArrayList<String> planet = new ArrayList<>(Arrays.asList(numArray));
        for(int t = 1; t <= T; t++){
            String[] info = br.readLine().split(" ");
            int length = Integer.parseInt(info[1]);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] map = new int[10];
            for(int i = 0; i < length; i++){
                String word = st.nextToken();
                map[planet.indexOf(word)] += 1;
            }
            System.out.println("#"+t);
            for(int i = 0; i < T; i++){
                for(int j = 0; j < map[i]; j++){
                    System.out.print(numArray[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
