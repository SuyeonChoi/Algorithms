import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2961 {
    //전역변수
    static int N; //재료의 개수
    static long[] S; //각 재료의 신맛을 저장하는 배열
    static long[] B; //각 재료의 쓴맛을 저장하는 배열
    static long ans = Long.MAX_VALUE; //신맛과 쓴맛의 차이가 가장 작은 요리의 차이(결과값)
    static boolean[] isSelected; //부분집합 포함 여부 저장한 배열


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받기
        N = Integer.parseInt(br.readLine());
        S = new long[N];
        B = new long[N];
        isSelected = new boolean[N];
        //재료의 개수만큼 신만과 쓴맛 각각 입력받는다.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
        }
        //부분집합을 통해 답을 구하는 food() 함수 호출
        powerSet(0);
        //결과 출력
        System.out.println(ans);
    }

    private static void powerSet(int cnt) {
        if (cnt == N) {
            long s = 1, b = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    s *= S[i];
                    b += B[i];
                }
            }
            if (s == 1 && b == 0) return;
            if (ans > Math.abs(s - b)) {
                ans = Math.abs(s - b);
            }
        } else {
            isSelected[cnt] = true;
            powerSet(cnt + 1);
            isSelected[cnt] = false;
            powerSet(cnt + 1);
        }
    }
}