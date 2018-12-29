package 兔子斐波那契数列;

import java.util.Scanner;

public class Test1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long s1 = 1, s2 = 1;
		System.out.println("请输入月份");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		for (int i = 1; i <= month; i++) {
			if (i == 1) {
				System.out.println("第" + i + "月份的兔子数为：" + s1);
			} else if (i == 2) {
				System.out.println("第" + i + "月份的兔子数为：" + s1);
			} else {
				long temp = s2;
				s2 = s1 + s2;
				s1 = temp;
				System.out.println("第" + i + "月份的兔子数为：" + s2);
			}
		}
	}
}