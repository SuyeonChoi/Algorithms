import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int idx = Integer.parseInt(br.readLine());
            String[] word = br.readLine().split("");
            String str = br.readLine();
            String[] sen = str.split("");
            int cnt = 0;
            for (int i = 0; i < sen.length; i++) {
                boolean isSame = true;
                int curIdx = i;
                for (int j = 0; j < word.length; j++) {
                    if(curIdx == sen.length){
                        isSame = false;
                        break;
                    }
                    if (!(sen[curIdx].equals(word[j]))) {
                        isSame = false;
                        break;
                    }
                    curIdx += 1;
                }
                if (isSame) {
                    cnt += 1;
                }
            }
            System.out.println("#" + idx + " " + cnt);
        }
    }
}
