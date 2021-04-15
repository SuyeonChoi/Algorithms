package Programmers;

public class season2_april_1 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int num = absolutes[i];
            if(!signs[i]){
                num = -num;
            }
            answer += num;
        }
        return answer;
    }
}
