package 完数;

public class Main {

	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			if (wanshu(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean wanshu(int i) {
		int sum = 0;
		for (int j = 1; j < i; j++) {
			if (i % j == 0) {
				sum += j;
			}
		}
		return sum == i;
	}
}
