package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Workout_Uniform {
    public int solution(int n, int[] lost, int[] reserve) {
        //1. 여유분이 있는 학생에서 도난당한 학생이 있는지 확인
        //2. 앞번호로부터 먼저 빌리기
        //3. 뒷번호로부터 먼저 빌리기
        //4. 2,3중 더 많이 빌릴수 있는 값을 리턴

        int[] students = new int[n + 1];
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]]++;
        }

        int[] copyStudents = Arrays.copyOf(students, n + 1);
        for (int i = 1; i <= n; i++) {
            if (copyStudents[i] == -1) {
                if (i - 1 > 0 && copyStudents[i - 1] == 1) {
                    copyStudents[i] = 0;
                    copyStudents[i - 1]--;
                } else if (i + 1 <= n && copyStudents[i + 1] == 1) {
                    copyStudents[i] = 0;
                    copyStudents[i + 1]--;
                }
            }
        }
        int frontBorrow = count(n, copyStudents);

        copyStudents = Arrays.copyOf(students, n + 1);
        for (int i = n; i >= 0; i--) {
            if (copyStudents[i] == -1) {
                if (i + 1 <= n && copyStudents[i + 1] == 1) {
                    copyStudents[i + 1]--;
                    copyStudents[i] = 0;
                } else if (i - 1 >= 1 && copyStudents[i - 1] == 1) {
                    copyStudents[i - 1]--;
                    copyStudents[i] = 0;
                }
            }
        }
        int backBorrow = count(n, copyStudents);

        int answer = Math.max(frontBorrow, backBorrow);
        return answer;
    }

    private int count(int n, int[] copyStudents) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (copyStudents[i] >= 0) cnt++;
        }
        return cnt;
    }
}