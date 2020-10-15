import java.util.Scanner;

public class p14889 {
    static int N;
    static int[][] ability;
    static boolean[] visited;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        ability = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ability[i][j] = scan.nextInt();
            }
        }
        combi(0, 0);
        System.out.println(Min);


    }

    //idx는 index, count는 재귀횟수
    static void combi(int idx, int count) {
        if(count == N / 2){
            calcDiff();
            return;
        }
        //BackTracking으로 Combination구하기
        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    //두 팀 능력차이 계산
    static void calcDiff(){
        int start_sum = 0;
        int link_sum = 0;
        for (int i = 0; i < N-1; i++){
            for (int j = i + 1; j < N; j++){
                if(visited[i] == true && visited[j] == true){
                    start_sum += ability[i][j];
                    start_sum += ability[j][i];
                }
                if(visited[i] == false && visited[j] == false){
                    link_sum += ability[i][j];
                    link_sum += ability[j][i];
                }
            }
        }
        Min = Math.min(Min, Math.abs(start_sum - link_sum));
    }


}
