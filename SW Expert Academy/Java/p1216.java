import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            int idx = Integer.parseInt(br.readLine());
            String[][] wordmap = new String[100][100];
            for (int i = 0; i < 100; i++) {
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < 100; j++) {
                    wordmap[i][j] = tmp[j];
                }
            }
            int max = 1;
            //Row에서 찾기
            boolean flag = false;
            for(int size = 1; size < 100; size++){
                for(int i = 0; i < 100; i++){
                    flag = true;
                    for(int j = 0; j + size < 100; j++){
                        flag = true;
                        for(int k = 0; k <= size; k++){
                            if(!(wordmap[i][j + k].equals(wordmap[i][j+size-k]))){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            max = size+1;
                            break;
                        }
                    }
                }
            }

            //Col에서 찾기
            flag = false;
            for(int size = 1; size < 100; size++){
                if(size+1 <= max){
                    continue;
                }
                for(int i = 0; i < 100; i++){
                    flag = true;
                    for(int j = 0; j + size < 100; j++){
                        flag = true;
                        for(int k = 0; k <= size; k++){
                            if(!(wordmap[j+k][i].equals(wordmap[j+size-k][i]))){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            max = size+1;
                            break;
                        }
                    }
                }
            }


            System.out.println("#" + t + " " + max);
        }
    }
}
