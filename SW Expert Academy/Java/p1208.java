import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 0; test < 10; test++) {
            int dump = Integer.parseInt(br.readLine());
            int[] boxes = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                int height = Integer.parseInt(st.nextToken());
                boxes[height] += 1;
            }
            for (int i = 0; i < dump; i++) {
                int maxIdx = findMax(boxes);
                int minIdx = findMin(boxes);
                if((maxIdx - minIdx) < 2){
                    break;
                }
                boxes[maxIdx] -= 1;
                boxes[minIdx] -= 1;
                boxes[maxIdx-1] += 1;
                boxes[minIdx+1] += 1;
            }
            System.out.println("#" + (test + 1) + " " + (findMax(boxes)-findMin(boxes)));
        }
    }




    private static int findMax(int[] boxes) {
        for(int i = boxes.length-1; i >=0; i--){
            if(boxes[i] != 0){
                return i;
            }
        }
        return -1;
    }

    private static int findMin(int[] boxes) {
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i] != 0){
                return i;
            }
        }
        return -1;
    }

}
