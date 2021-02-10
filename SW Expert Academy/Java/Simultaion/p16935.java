import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p16935 {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int r = 0; r < R; r++) {
            int op = Integer.parseInt(st.nextToken());
            switch (op) {
                case 1:
                    reverseTopBottom();
                    break;
                case 2:
                    reverseLeftRight();
                    break;
                case 3:
                    rotateRight();
                    break;
                case 4:
                    rotateLeft();
                    break;
                case 5:
                    switchGroup1();
                    break;
                case 6:
                    switchGroup2();
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void switchGroup2() {
        int midX = N / 2;
        int midY = M / 2;
        int[][] firstGroup = new int[midX][midY];
        for (int i = 0; i < midX; i++) {
            for (int j = 0; j < midY; j++) {
                firstGroup[i][j] = arr[i][j];
            }
        }
        //group2 -> group1
        for (int i = 0; i < midX; i++) {
            for (int j = 0; j < midY; j++) {
                arr[i][j] = arr[i][midY + j];
            }
        }
        //group3 -> group2
        for (int i = 0; i < midX; i++) {
            for (int j = midY; j < M; j++) {
                arr[i][j] = arr[i+midX][j];
            }
        }
        //group4 -> group3
        for (int i = midX; i < N; i++) {
            for (int j = midY; j < M; j++) {
                arr[i][j] = arr[i][j - midY];
            }
        }
        //group1 -> group4
        for (int i = midX; i < N; i++) {
            for (int j = 0; j < midY; j++) {
                arr[i][j] = firstGroup[i- midX][j];
            }
        }

    }

    private static void switchGroup1() {
        int midX = N / 2;
        int midY = M / 2;
        int[][] firstGroup = new int[midX][midY];
        for (int i = 0; i < midX; i++) {
            for (int j = 0; j < midY; j++) {
                firstGroup[i][j] = arr[i][j];
            }
        }
        //group4 -> group1
        for (int i = 0; i < midX; i++) {
            for (int j = 0; j < midY; j++) {
                arr[i][j] = arr[i + midX][j];
            }
        }
        //group3 -> group4
        for (int i = midX; i < N; i++) {
            for (int j = 0; j < midY; j++) {
                arr[i][j] = arr[i][M - midY + j];
            }
        }
        //group2 -> group3
        for (int i = midX; i < N; i++) {
            for (int j = midY; j < M; j++) {
                arr[i][j] = arr[i - midX][j];
            }
        }
        //group1 -> group2
        for (int i = 0; i < midX; i++) {
            for (int j = midY; j < M; j++) {
                arr[i][j] = firstGroup[i][j - midY];
            }
        }

    }

    private static void rotateRight() {
        int[][] newArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[j][N - i - 1] = arr[i][j];
            }
        }
        swap(N, M);
        arr = newArr;
    }

    private static void rotateLeft() {
        int[][] newArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[M - j - 1][i] = arr[i][j];
            }
        }
        swap(N, M);
        arr = newArr;
    }

    private static void swap(int n, int m) {
        N = m;
        M = n;
    }

    private static void reverseLeftRight() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = tmp;
            }
        }
    }

    private static void reverseTopBottom() {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[N - i - 1][j];
                arr[N - i - 1][j] = tmp;
            }
        }
    }
}
