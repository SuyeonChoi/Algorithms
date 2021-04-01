package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneNumber_List {
    public static void main(String[] args) {
        String[] pb = {"119", "97674223", "1195524421"};
        solution(pb);
    }

    public static boolean solution(String[] phone_book) {
        HashSet<String> map = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.add(phone_book[i]);
        }
        for (int i = 0; i < phone_book.length; i++) {
            String str = phone_book[i];
            for (int j = 1; j < str.length(); j++) {
                if (map.contains(str.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

}
