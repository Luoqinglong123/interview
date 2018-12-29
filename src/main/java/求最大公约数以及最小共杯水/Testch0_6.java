package 求最大公约数以及最小共杯水;

import java.util.Scanner;

public class Testch0_6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 调用java.util.Scanner可以获得从键盘输入的数字;
		Scanner sc = new Scanner(System.in);
		// 定义两个整型数字的变量
		int min;
		int max;
		System.out.print("请输入一个数：");
		min = sc.nextInt();// nextInt();方法用来获取输入的Int NUM
		System.out.print("请输入另一个数：");
		max = sc.nextInt();
		// 调用后面的静态方法；
		System.out.println(gongyue(min, max));
		System.out.println(gongbei(min, max));
	}

	// a与b的最大公约数
	public static int gongyue(int min, int max) {
		while (max % min != 0) {
			/**
			 * 运用递归调用将求余之后的值作为min 将之前的min作为max直到求余值为0为止结束循环
			 */
			int temp = max % min;
			max = min;
			min = temp;
		}
		return min;
	}

	// a与b的最小公倍数
	public static int gongbei(int min, int max) {
		// 求公倍数就是将两个数相乘除以最大公约数
		return min * max / gongyue(min, max);
	}

}