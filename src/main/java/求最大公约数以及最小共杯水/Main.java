package 求最大公约数以及最小共杯水;

�����Լ���Լ���С����ˮ;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������һ��ֵ��");
		int x = scanner.nextInt();
		System.out.println("������ڶ���ֵ��");
		int y = scanner.nextInt();
		int a = gongyue(x, y);
		int b = gongbei(a,x, y);
		System.out.println("��Լ���ǣ�"+a);
		System.out.println("�������ǣ�"+b);

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
