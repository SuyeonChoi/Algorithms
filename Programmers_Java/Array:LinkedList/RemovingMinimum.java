package Programmers;

public class RemovingMinimum {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for(int i = 0; i < answer.length; i++) {
            if(arr[idx] == min) {
                i--;
                idx++;
            } else {
                answer[i] = arr[idx++];
            }
        }
        return answer;
    }
}
