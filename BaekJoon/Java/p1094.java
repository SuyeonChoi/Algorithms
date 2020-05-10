import java.util.Scanner;

public class p1094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] stick = new int[64];
		stick[0] = 64;
		stick[1] = 64;
		int size = 1;
		while(n<=stick[0]) {//n<64
			if(stick[0]>n) {
				stick[size]=stick[size]/2;
				int sum = 0;
				for(int i=1; i<=size;i++) {
					sum+= stick[i];
				}
				stick[0] = sum;
				if(sum<n) {
					stick[size+1] = stick[size]; 
					size++;
					stick[0] = sum+stick[size];
				}
			}
			else {
				break;
			}
		}
		System.out.println(size);
	}

}
