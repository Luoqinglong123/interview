package 求最大公约数以及最小共杯水;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个值：");
		int x = scanner.nextInt();
		System.out.println("请输入第二个值：");
		int y = scanner.nextInt();
		int a = gongyue(x, y);
		int b = gongbei(a,x, y);
		System.out.println("公约数是："+a);
		System.out.println("公倍数是："+b);

	}

	private static int gongbei(int a,int x, int y) {
		return x*y/a;
	}

	private static int gongyue(int x, int y) {
		while(x%y!= 0 ){
			int tmp = x%y;
			x = y;
			y = tmp;
		}
		return y;
	}

}