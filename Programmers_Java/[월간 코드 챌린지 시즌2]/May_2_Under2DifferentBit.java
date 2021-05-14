package Programmers;

public class May_2_Under2DifferentBit {
    public static void main(String[] args) {
        solution(new long[]{11, 7});
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findClosest(numbers[i]);
        }
        return answer;
    }

    private static long findClosest(long number) {
        String origin = Long.toBinaryString(number);
        if (origin.charAt(origin.length() - 1) == '0') {
            return number + 1;
        } else {
            int i = 0;
            for (i = origin.length() - 1; i >= 0; i--) {
                if (origin.charAt(i) == '0') {
                    break;
                }
            }
            String nxtNum;
            if (i == -1) {
                //모두 1인 경우
                nxtNum = "10" + origin.substring(1);

            } else {
                //0이 한개라도 있음
                nxtNum = origin.substring(0, i) + "10" + origin.substring(i + 2);
            }

            return Long.parseLong(nxtNum, 2);
        }
    }
}
