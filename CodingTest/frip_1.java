import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

public class frip_1 {
    public static int solution(int[][] location, int[] s, int[] e) {
        int answer = 0;
//        System.out.println(location.length);
        int x_min = Math.min(s[0], e[0]);
        int x_max = Math.max(s[0], e[0]);
        int y_min = Math.min(s[1], e[1]);
        int y_max = Math.max(s[1], e[1]);
        for(int i = 0; i < location.length; i++){
            if(location[i][0] >= x_min && location[i][0] <= x_max){
                if (location[i][1] >= y_min && location[i][1] <= y_max){
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] location = {{0, 3}, {1, 1}, {1, 5}, {2, 2}, {3, 3}, {4, 0}};
        int[] s = {1, 4};
        int[] e = {4, 1};
        solution(location, s, e);
    }
}
