import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, LinkedList<String>> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(map.keySet().contains(age)){
                map.get(age).add(name);
            }else{
                LinkedList<String> valueList = new LinkedList<>();
                valueList.add(name);
                map.put(age, valueList);
            }
        }
        //key가 있는 List 정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
//        keyList.sort((age1, age2) -> age1.compareTo(age2));
        StringBuilder sb = new StringBuilder();
        for(Integer key: keyList){
            LinkedList<String> valueList = map.get(key);
            for(int i = 0; i < valueList.size(); i++){
                sb.append(key).append(" ").append(valueList.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
