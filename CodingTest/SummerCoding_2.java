import java.math.BigInteger;

public class SummerCoding_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.solution(4));
		System.out.println(sol.solution(11));
	}

}

class Solution {
	public long solution(long n) {
		// long만큼 사이즈의 배열 처리가 안됨
		// BigInt 배열 시도하였으나 실패
		int size = (int) n;
		long[] array = new long[size];
		if (n == 1) {
			return (long) Math.pow(3, 0);
		} else if (n == 2) {
			return (long) Math.pow(3, 1);
		} else if (n == 3) {
			return (long) Math.pow(3, 2);
		} else {
			array[0] = (long) Math.pow(3, 0);
			array[1] = (long) Math.pow(3, 1);
			array[2] = array[0] + array[1];
			int sqrt = 2;
			for (int i = 3; i < size; i++) {
				long x = (long) Math.pow(3, sqrt);
				array[i] = x;
				int count = i;
				for (int j = 0; j < count; j++) {
					i++;
					if (i >= size)
						break;
					array[i] = x + array[j];
				}
				sqrt++;
			}
		}
		return array[size - 1];

	}
}