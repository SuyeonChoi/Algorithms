package CodingTest;

//배열 돌리기 문제
public class DevMatching_2021_2 {
    static int[][] square;

    public static void main(String[] args) {
        int r = 6;
        int c = 6;
        int[][] q = {{2, 2, 5, 4},{
            3, 3, 6, 6
        },{
            5, 1, 6, 3
        }};
//        int[][] q = {{1, 1, 2, 2},{
//            1, 2, 2, 3
//        },{2, 1, 3, 2
//        },{
//            2, 2, 3, 3
//        }};
        solution(r, c, q);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        square = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                square[i][j] = value++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int num = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
            answer[i] = num;
        }
        return answer;
    }

    private static int rotate(int x1, int y1, int x2, int y2) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int R = x2 - x1 + 1; //가로 길이
        int C = y2 - y1 + 1; //세로 길이
        int I = Math.min(R, C);
        int minNum = square[x1][y1];
//        for (int i = 0; i < I / 2; i++) {
            int cnt = 0;
            int x = x1;
            int y = y1;
            int tmp = square[x][y];
            while (cnt < 4) {
                int nx = x + dx[cnt];
                int ny = y + dy[cnt];
                if (nx >= x1 && nx <= x2 && ny >= y1 && ny <= y2) {
//                    System.out.println(x+" "+ y);
//                    System.out.println(nx+" "+ ny);
                    square[x][y] = square[nx][ny];
                    x = nx;
                    y = ny;
                    minNum = Math.min(minNum, square[x][y]);
                } else {
                    cnt++;
                }
            }
            square[x1][y1 + 1] = tmp;
//        }
        return minNum;
    }
}
