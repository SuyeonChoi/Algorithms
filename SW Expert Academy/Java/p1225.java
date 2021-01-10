import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t < 11; t++){
            int idx = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8; i++){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int cnt = 1;
            while(true){
                if(cnt > 5){
                    cnt = 1;
                }
                if((queue.peek() - cnt) <= 0){
                    queue.poll();
                    queue.offer(0);
                    break;
                }
                queue.offer(queue.poll()-cnt);
                cnt++;
            }
            System.out.print("#"+ t+ " ");
            while (! queue.isEmpty()){
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
