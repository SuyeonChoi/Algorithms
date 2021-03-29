package Algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 정수와 그에 해당하는 문자열을 가지는 클래스
// Comparable을 통해 자체 정렬 구현
class Number implements Comparable<Number> {
    int num; // 정수
    String sound; // 정수를 읽었을 때의 문자열

    public Number(int num, String sound) { // Number클래스의 생성자
        this.num = num;
        this.sound = sound;
    }

    // 자체 정렬 기준을 위해 compareTo 메소드를 재정의
    @Override
    public int compareTo(Number o) {
        // 정수값과 별개로 문자열(알파벳)만 비교하면 ㅁ되므로 sound값끼리 비교
        // sound가 문자열이므로 문자열을 비교하는 compareTo 함수 사용
        return this.sound.compareTo(o.sound);
    }
}

public class p1755 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 최적화를 위한 BufferedReader사용
        StringTokenizer st = new StringTokenizer(br.readLine()); // N, M을 구분하여 입력받기 위해 StringTokenizer 사용
        int N = Integer.parseInt(st.nextToken()); // N 값 입력받기
        int M = Integer.parseInt(st.nextToken()); // M 값 입력받기
        ArrayList<Number> numList = new ArrayList<>(); // ArrayList를 통해 해당 범위(N이상 M이하)의 정수와 그 문자열을 저장 및 관리

        for (int i = N; i <= M; i++) {
            // 주어지는 정수범위가 1이상 99이므로 한자리수와 두자리수로 경우를 나누어 처리
            String str = ""; // 변환된 문자열을 저장하는 변수
            if (i / 10 == 0) { // 한자리 수인 경우
                str = makeString(i); // 일의자리만 처리
            } else { // 두자리수인 경우
                str = makeString(i / 10); // 십의자리 처리
                str += makeString(i % 10); // 일의자리 처리
            }
            numList.add(new Number(i, str)); // 변환한 문자열을 정수와 함께 리스트에 저장
        }

        // 정수에 해당하는 알파벳 순으로 정렬
        Collections.sort(numList);

        // 출력
        StringBuilder sb = new StringBuilder(); // 출력값 최적화을 위해 StringBuilder를 사용
        int idx = 0; // 개행을 위한 변수
        for (Number number : numList) { // 리스트의 모든 값을 출력해야함
            sb.append(number.num).append(" "); // Number클래스의 정수만 출력하므로 num값만 가져옴
            idx++; // 1씩 증가시켜 현재까지 출력개수 저장
            if (idx % 10 == 0) { // 10개마다
                sb.append("\n"); // 개행
            }
        }
        System.out.println(sb);
    }

    // 정수를 알파벳으로 읽었을 때의 문자열로 변환해주는 함수
    private static String makeString(int n) {
        // TODO Auto-generated method stub
        String s = ""; // 정수가 변환될 문자열

        // switch 문을 통해 파라미터로 입력받은 정수값과 일치하는 case로 매칭
        // case에서는 해당 정수에 해당하는 문자열을 변수에 저장
        switch (n) {
            case 0: // 정수가 0인 경우
                s = "zero";
                break;
            case 1:// 정수가 1인 경우
                s = "one";
                break;
            case 2:// 정수가 2인 경우
                s = "two";
                break;
            case 3:// 정수가 3인 경우
                s = "three";
                break;
            case 4:// 정수가 4인 경우
                s = "four";
                break;
            case 5:// 정수가 5인 경우
                s = "five";
                break;
            case 6:// 정수가 6인 경우
                s = "six";
                break;
            case 7:// 정수가 7인 경우
                s = "seven";
                break;
            case 8:// 정수가 8인 경우
                s = "eight";
                break;
            case 9:// 정수가 9인 경우
                s = "nine";
                break;

        }

        // 변환된 문자열 반환
        return s;
    }

}
