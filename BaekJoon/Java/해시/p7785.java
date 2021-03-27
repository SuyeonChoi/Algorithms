package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> employee = new HashSet<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();
            if(record.equals("enter")){
                employee.add(name);
            }else{
                employee.remove(name);
            }
        }
        //List 변환
        List employeeList = new ArrayList(employee);
        //정렬
        Collections.sort(employeeList, Comparator.reverseOrder());
        //출력 
        StringBuilder sb = new StringBuilder();
        for(Object s : employeeList){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
