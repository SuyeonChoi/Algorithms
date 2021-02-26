import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pillars = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillars[i][0] = Integer.parseInt(st.nextToken());
            pillars[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pillars, (o1, o2) -> o1[0] - o2[0]);
        int highestIdx = searchHighest(pillars, 0, N);
        int area = pillars[highestIdx][1];
        //왼쪽탐색
        int leftIdx = highestIdx;
        while (leftIdx != 0) {
            int tmpIdx = searchHighest(pillars, 0, leftIdx);
            area += (pillars[tmpIdx][1] * (pillars[leftIdx][0] - pillars[tmpIdx][0]));
            leftIdx = tmpIdx;
        }
        //오른쪽탐색
        int rightIdx = highestIdx;
        while (rightIdx != N - 1) {
            int tmpIdx = searchHighest(pillars, rightIdx+1, N);
            area += (pillars[tmpIdx][1] * (pillars[tmpIdx][0] - pillars[rightIdx][0]));
            rightIdx = tmpIdx;
        }
        System.out.println(area);
    }

    private static int searchHighest(int[][] pillars, int st, int en) {
        int highest = 0, highestIdx = -1;
        for (int i = st; i < en; i++) {
            if (highest < pillars[i][1]) {
                highest = pillars[i][1];
                highestIdx = i;
            }
            highest = Math.max(highest, pillars[i][1]);
        }
        return highestIdx;
    }
}
