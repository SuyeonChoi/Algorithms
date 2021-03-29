package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2629 {
    static int N;
    static int[] chu;
    static boolean[] isSelected;
    static boolean[] rightSelected;
    static int marvel;
    static int leftSide;
    static ArrayList<Integer> rightSet;
    static String ans;


    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 추의 갯수
        chu = new int[N+1]; //추
        dp = new boolean[N+1][15001]; // N개까지 넣었을때 측정할 수 있는 무게
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 입력받은 추의 무게를 배열에 저장
            chu[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) { // 입력받은 구슬의 무게를 배열에 저장
            marvel = Integer.parseInt(st.nextToken()); // 현재 측정할 구슬의 무게
            if (marvel > 15000) { //최대 측정 무게 초과
                sb.append("N").append(" ");
            } else {
                if (dp[N][marvel]){ //가능
                    sb.append("Y").append(" ");
                }else{ //불가
                    sb.append("N").append(" ");
                }
            }

        }
        System.out.println(sb);
    }

    private static void solution(int i, int weight) {
        if (i > N || dp[i][weight]) return;
        dp[i][weight] = true;
        //i번째 추를 추측에 올림
        solution(i + 1, weight + chu[i]);
        //i번째 추를 구슬측에 올림
        solution(i + 1, Math.abs(weight - chu[i]));
        //i번째 추를 올리지 않음
        solution(i + 1, weight);
    }
}