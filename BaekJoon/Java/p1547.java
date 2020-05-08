import java.util.Scanner;

public class p1547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pos = 1;
		Scanner scan = new Scanner(System.in);
		int loop = scan.nextInt();
		for(int i = 0 ; i< loop; i++) {
			int fir = scan.nextInt();
			int sec = scan.nextInt();
			if(fir == pos) {
				pos = sec;
			}
			else if(sec == pos) {
				pos = fir;
			}
		}
		System.out.println(pos);
	}

}
