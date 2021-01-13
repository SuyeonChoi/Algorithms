package day0113_start01;

import java.util.*;

public class sw_p2072 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int num = scan.nextInt();
				if (num % 2 == 1) {
					sum += num;
				}
			}

			System.out.println("#" + t + " " + sum);
		}

	}
}
