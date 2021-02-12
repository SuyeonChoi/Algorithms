import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <=T; t++){
            int ans = 0;
            String[] peopleStr = br.readLine().split("");
            int[] people = new int[peopleStr.length];
            for(int i = 0; i < people.length; i++){
                people[i] = Integer.parseInt(peopleStr[i]);
            }
            int clapping = people[0];
            for(int i = 1; i < people.length; i++){
                if(people[i] == 0) continue;
                if(i <= clapping){
                    clapping += people[i];
                }else{
                    ans += (i - clapping);
                    clapping = i + people[i];
                }
            }

            System.out.println("#"+t+" "+ans);
        }
    }
}
