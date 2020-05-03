import java.util.*;
public class p14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int quitDay = scan.nextInt();
		
		int[] time_array = new int[quitDay];
		int[] price_array = new int[quitDay];
		int[] sum_array = new int[quitDay+1];
		
		for(int i = 0; i<quitDay; i++) {
			int time = scan.nextInt();
			time_array[i] = time;
			int price = scan.nextInt();
			price_array[i] = price;
		}
		
		for(int i = 0; i < quitDay; i++) {
			for(int j = i+time_array[i]; j<=quitDay; j++) {
				if( sum_array[i]+price_array[i] > sum_array[j]) {
					sum_array[j] = sum_array[i]+price_array[i];
				}
				else {
					sum_array[j] = sum_array[j];
				}
				
			}
		}
		
		System.out.println(sum_array[quitDay]);
	}

}
