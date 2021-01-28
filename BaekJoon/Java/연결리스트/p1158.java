import java.util.*;

public class p1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt()-1;
		int length = K;
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i<N; i++) {
			list.add(i+1);
		}
		System.out.print("<");
		while(!list.isEmpty()) {
			int rm = list.remove(K);
			K = K+length;
			System.out.print(rm);
			if(list.size()>0)
				System.out.print(", ");
			if(list.size() == 0) {
				System.out.print(">");
				break;
			}
			if(K>list.size()-1) {
				K = K%list.size();
			}
			
		}
	}
	
}
