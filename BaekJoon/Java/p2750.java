import java.util.*;
public class p2750 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List listA = new ArrayList();
        for(int i = 0; i<num; i++){
            listA.add(scan.nextInt());
        }
        Collections.sort(listA);
        for(int i = 0; i< num; i++){
            System.out.println(listA.get(i));
        }
    }
}
