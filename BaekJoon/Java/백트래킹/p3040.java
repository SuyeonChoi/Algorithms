import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p3040 {
    static int[] dwarves = new int[9];
    static int[] selectedDwarves = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            dwarves[i] = Integer.parseInt(br.readLine());
        }
        combi(0, 0);
    }

    private static void combi(int cnt, int st) {
        if(cnt == 7){
            if(Arrays.stream(selectedDwarves).sum() == 100){
                for(int dwarf: selectedDwarves){
                    System.out.println(dwarf);
                }
                return;
            }
        }else{
            for(int i = st; i < 9 ; i++){
                selectedDwarves[cnt] = dwarves[i];
                combi(cnt+1, i+1);
            }
        }
    }
}
