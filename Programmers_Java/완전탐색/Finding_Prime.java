package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Finding_Prime {
    static int N;
    static int M;
    static int[] input; // 부분집합
    static boolean[] isSelected; // 부분집합
    static int[] subset; // 부분집합
    static int[] numbers; // 조합
    static boolean[] permSelected; // 조합
    static Set<Integer> set;

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        N = numbers.length();
        input = new int[N];
        isSelected = new boolean[N];
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            input[i] = numbers.charAt(i) - '0';
        }

        powerSet(0, 0);
        int answer = set.size();
        return answer;
    }

    private static void powerSet(int cnt, int size) {
        if (cnt == N) {
            if (size == 0) return;
            M = size;
            numbers = new int[size];
            subset = new int[size];
            permSelected = new boolean[size];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    subset[idx++] = input[i];
                }
            }
            perm(0);
        } else {
          isSelected[cnt] = true;
          powerSet(cnt + 1, size + 1);
          isSelected[cnt] = false;
          powerSet(cnt + 1, size);
        }
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            String result = "";
            for (int i = 0; i < M; i++) {
                if (permSelected[i]) {
                    if (numbers[i] == 0 && result.length() == 0) continue;
                    result = result + numbers[i];
                }
            }
            if (result.length() > 0 && isPrime(Integer.parseInt(result))) {
                set.add(Integer.parseInt(result));
            }
        } else {
            for (int i = 0; i < M; i++) {
                if (permSelected[i]) continue;
                permSelected[i] = true;
                numbers[cnt] = subset[i];
                perm(cnt + 1);
                permSelected[i] = false;
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
