import java.util.*;

class ArrayStack {
	private Object[] a;
	private int size;

	public ArrayStack(int capacity) {
		a = new Object[capacity];
	}

	public void pop() {
		// TODO Auto-generated method stub
		if(size == 0) throw new IllegalStateException("stack is empty");
		a[--size] = null;
	}

	public void push(String string) {
		// TODO Auto-generated method stub
		if(a.length == size) {
			resize();
		}
		a[size] = string;
		size++;
	}

	private void resize() {
		// TODO Auto-generated method stub
		Object[] aa = a;
		a = new Object[aa.length*2];
		System.arraycopy(aa, 0, a, 0, size);
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}

public class p10799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		String array[] = text.split("");
		int result = 0;
		ArrayStack mystack = new ArrayStack(array.length);
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals("(")&&array[i+1].equals(")")) {//레이저가 나온경우
				result+=mystack.size();
				i++;
			}else if(array[i].equals(")")){//쇠막대기 끝
				mystack.pop();
			}else {//쇠막대기 나온경우
				result++;
				mystack.push(array[i]);
			}
			// System.out.print(array[i]);
			
		}
		System.out.println(result);
	}

}
