import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1873 {
    static char[][] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            field = new char[H][W];
            char dir = '0';
            int curX = 0, curY = 0;
            for (int i = 0; i < H; i++) {
                field[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if (field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
                        curX = i;
                        curY = j;
                        if (field[i][j] == '^') dir = 'U';
                        else if (field[i][j] == 'v') dir = 'D';
                        else if (field[i][j] == '<') dir = 'L';
                        else if (field[i][j] == '>') dir = 'R';
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < N; i++) {
                if(input[i] == 'S'){
                    int bombX = curX, bombY = curY;
                    switch (dir) {
                        case 'U':
                            while (bombX >= 0){
                                bombX--;
                                if(bombX < 0 || field[bombX][bombY] == '#') break;
                                if(field[bombX][bombY] == '*'){
                                    field[bombX][bombY] = '.';
                                    break;
                                }
                            }
                            break;
                        case 'D':
                            while (bombX < H){
                                bombX++;
                                if(bombX >= H || field[bombX][bombY] == '#') break;
                                if(field[bombX][bombY] == '*'){
                                    field[bombX][bombY] = '.';
                                    break;
                                }
                            }
                            break;
                        case 'R':
                            while (bombY < W){
                                bombY++;
                                if(bombY >= W || field[bombX][bombY] == '#') break;
                                if(field[bombX][bombY] == '*'){
                                    field[bombX][bombY] = '.';
                                    break;
                                }
                            }
                            break;
                        case 'L':
                            while (bombY >= 0){
                                bombY--;
                                if(bombY < 0 || field[bombX][bombY] == '#') break;
                                if(field[bombX][bombY] == '*'){
                                    field[bombX][bombY] = '.';
                                    break;
                                }
                            }
                            break;
                    }
                    continue;
                }
                int nx = curX, ny = curY;
                switch (input[i]) {
                    case 'U':
                        nx--;
                        dir = 'U';
                        break;
                    case 'D':
                        nx++;
                        dir = 'D';
                        break;
                    case 'R':
                        ny++;
                        dir = 'R';
                        break;
                    case 'L':
                        dir = 'L';
                        ny--;
                        break;
                }
                setPos(dir, curX, curY);
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) { //이동불가. 맵 밖의 영역
                    continue;
                }
                if(field[nx][ny] == '.'){ //평지라면 이동
                    field[curX][curY] = '.';
                    curX = nx;
                    curY = ny;
                    setPos(dir, curX, curY);
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void setPos(char dir, int curX, int curY) {
        if(dir == 'U') field[curX][curY] = '^';
        else if (dir == 'D') field[curX][curY] = 'v';
        else if (dir == 'R') field[curX][curY] = '>';
        else if (dir == 'L') field[curX][curY] = '<';
    }
}
