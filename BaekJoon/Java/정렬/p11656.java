package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        ArrayList<String> suffix = new ArrayList<>();
        for(int i = 0; i < str.length - 1; i++){
            char[] tmp = Arrays.copyOfRange(str, i, str.length);
            suffix.add(new String(tmp));
        }
        suffix.add(Character.toString(str[str.length - 1]));

        Collections.sort(suffix);
        for(String s: suffix){
            System.out.println(s);
        }
//        System.out.println(suffix);

    }
}
