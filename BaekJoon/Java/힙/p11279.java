import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p11279 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = scan.nextInt();
        for(int i = 0; i < N; i++){
            int cmd = scan.nextInt();
            if(cmd == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.remove());
                }
            }
            else{
                pq.add(cmd);
            }
        }
    }
}
