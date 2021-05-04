package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> pockemonByName = new HashMap<>();
        Map<Integer, String> pockemonByNumber = new HashMap<>();
        int num = 1;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            pockemonByName.put(name, num);
            pockemonByNumber.put(num++, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            try {
                int index = Integer.parseInt(question);
                sb.append(pockemonByNumber.get(index)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(pockemonByName.get(question)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
