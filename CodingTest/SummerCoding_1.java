
public class SummerCoding_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(1987);
		solution(2015);
	}

	public static int solution(int p) {
		int answer = p;

		while (true) {
			answer++;
			int a = answer / 1000;
			int b = answer / 100 % 10;
			int c = answer / 10 % 10;
			int d = answer % 10;
			if (a != b && a != c && a != d && b != c && b != d && c != d) {
				break;
			}
		}
		return answer;
	}
}
