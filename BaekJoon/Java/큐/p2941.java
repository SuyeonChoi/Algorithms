import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p2941 {
    static Queue<Character> queue = new LinkedList<>();;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            queue.offer(str[i]);
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == 'c') {
                if (!queue.isEmpty() && queue.peek() == '=') { //c=
                    countCro();
                    continue;
                } else if (!queue.isEmpty() && queue.peek() == '-') { //c-
                    countCro();
                    continue;}
            } else if (c == 'd') {
                if (queue.size() >= 2 && queue.peek() == 'z') { //dz=
                    queue.poll(); //z
                    if (queue.peek() == '=') {
                        countCro();
                        continue;
                    }else{
                        cnt++;
                    }
                } else if (!queue.isEmpty() && queue.peek() == '-') { //d-
                    countCro();
                    continue;}
            } else if (c == 'l' || c == 'n') { //lj, nj
                if (!queue.isEmpty() && queue.peek() == 'j'){
                    countCro();
                    continue;
                }
            }else if(c == 's' || c == 'z'){ //s=, z=
                if (!queue.isEmpty() && queue.peek() == '='){
                    countCro();
                    continue;
                }
            }
            cnt++;

        }
        System.out.println(cnt);

    }

    private static void countCro() {
        cnt++;
        queue.poll();
    }
}