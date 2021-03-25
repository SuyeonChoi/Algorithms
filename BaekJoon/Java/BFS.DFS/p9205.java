package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class myPoint {
    int x;
    int y;

    public myPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p9205 {
    static int N;
    static int homeX, homeY;
    static int[][] cvs;
    static Queue<myPoint> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //inputs
            N = Integer.parseInt(br.readLine());
            cvs = new int[N+1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N+1; i++) {
                st = new StringTokenizer(br.readLine());
                cvs[i][0] = Integer.parseInt(st.nextToken());
                cvs[i][1] = Integer.parseInt(st.nextToken());
            }

            queue = new LinkedList<>();
            queue.offer(new myPoint(homeX, homeY));
            boolean[] vis = new boolean[N+1];
            boolean isHappy = false;

            while (! queue.isEmpty()){
                myPoint cur = queue.poll();
                if(cur.x == cvs[N][0] && cur.y == cvs[N][1]) {
                    isHappy = true;
                    break;
                }

                for(int i = 0; i < N+1; i++){
                    int dist = calcDist(cur.x, cur.y, cvs[i][0], cvs[i][1]);
                    if(!vis[i] && dist <= 1000){
                        vis[i] = true;
                        queue.offer(new myPoint(cvs[i][0], cvs[i][1]));
                    }
                }
            }

            if(isHappy){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }

    private static int calcDist(int curX, int curY, int nxtX, int nxtY) {
        return Math.abs(curX - nxtX) + Math.abs(curY - nxtY);
    }
}
