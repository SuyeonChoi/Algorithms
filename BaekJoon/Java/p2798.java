package HW03_BinarySearch;

import java.util.Scanner;

public class p2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //카드개수
		int M = scan.nextInt(); //기준값
		
		int array[] = new int[N];
		for(int i = 0 ; i<array.length; i++) {
			array[i] = scan.nextInt();
		}
		
		int max = 0;
		int temp = array.length-1;
		
		while(temp >= 0) {
			for(int i = temp-1; i>=1; i--) {
				for(int j = i-1; j>=0;j--) {
					int sum = array[temp]+array[i]+array[j];
					if(sum <= M && max <sum) {
						max = sum;
					}
				}
			}
			temp--;
		}
		System.out.println(max);
	}

}
