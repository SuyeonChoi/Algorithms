import java.util.*;

public class p2217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] rope = new int[n];
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			rope[i] = scan.nextInt();
		}
		Arrays.sort(rope);
		int max = 0;
		
		for(int i = 0; i<n; i++) {
			sum[i] = rope[i]*(n-i);
			if(sum[i]>max) {
				max = sum[i];
			}
		}
		System.out.println(max);
	}

}
