import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int size = Integer.parseInt(br.readLine());
            String[][] wordmap = new String[8][8];
            for (int i = 0; i < 8; i++) {
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < 8; j++) {
                    wordmap[i][j] = tmp[j];
                }
            }
            int ans = 0;
            //Row에서 찾기
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(j+size-1 < 8){
                        boolean isSame = true;
                        for(int k = 0; k < size; k++){
                            if(!(wordmap[i][j+k].equals(wordmap[i][j+size-k-1]))){
                                isSame = false;
                                break;
                            }
                        }
                        if(isSame){
                            ans += 1;
                        }
                    }
                }
            }
            //Col에서 찾기
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(j+size-1 < 8){
                        boolean isSame = true;
                        for(int k = 0; k < size; k++){
                            if(!(wordmap[j+k][i].equals(wordmap[j+size-k-1][i]))){
                                isSame = false;
                                break;
                            }
                        }
                        if(isSame){
                            ans += 1;
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}
