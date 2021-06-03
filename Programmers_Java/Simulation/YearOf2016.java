package Programmers;

public class YearOf2016 {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int days = 0;
        for (int i = 1; i < a; i++) {
            days += month[i-1];
        }
        days += b;

        return day[(days - 1) % 7];
    }
}
