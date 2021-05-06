package Programmers;

public class PressingKeypad {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String solution(int[] numbers, String hand) {
        Point leftHand = new Point(3, 0);
        Point rightHand = new Point(3, 2);
        StringBuilder answer = new StringBuilder();

        for (int n : numbers) {
            if (n == 0) n = 11;
            Point num = toPoint(n-1);
            if (num.y == 0) {
                leftHand = num;
                answer.append("L");
            } else if (num.y == 2) {
                rightHand = num;
                answer.append("R");
            } else {
                int leftDist = Math.abs(leftHand.x - num.x) + Math.abs(leftHand.y - num.y);
                int rightDist = Math.abs(rightHand.x - num.x) + Math.abs(rightHand.y - num.y);
                if (leftDist == rightDist) {
                    if (hand.equals("right")) {
                        rightHand = num;
                        answer.append("R");
                    } else {
                        leftHand = num;
                        answer.append("L");
                    }
                } else if (leftDist < rightDist) {
                    leftHand = num;
                    answer.append("L");
                } else {
                    rightHand = num;
                    answer.append("R");
                }
            }
        }
        return answer.toString();
    }

    private Point toPoint(int n) {
        return new Point(n / 3, n % 3);
    }
}
