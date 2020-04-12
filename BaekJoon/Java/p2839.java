import java.util.Scanner;

public class p2839 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int five = 0, three = 0;

		while(true) {
			if(n%5 == 0) {
				five = n/5;
				System.out.println(five+three);
				break;
			}
			else if(n<0) {
				System.out.println("-1");
				break;
			}
			three++;
			n -= 3;
		}
	}
}
