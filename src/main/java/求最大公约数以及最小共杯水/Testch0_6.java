package 求最大公约数以及最小共杯水;

�����Լ���Լ���С����ˮ;

import java.util.Scanner;

public class Testch0_6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����java.util.Scanner���Ի�ôӼ������������;
		Scanner sc = new Scanner(System.in);
		// ���������������ֵı���
		int min;
		int max;
		System.out.print("������һ������");
		min = sc.nextInt();// nextInt();����������ȡ�����Int NUM
		System.out.print("��������һ������");
		max = sc.nextInt();
		// ���ú���ľ�̬������
		System.out.println(gongyue(min, max));
		System.out.println(gongbei(min, max));
	}

	// a��b�����Լ��
	public static int gongyue(int min, int max) {
		while (max % min != 0) {
			/**
			 * ���õݹ���ý�����֮���ֵ��Ϊmin ��֮ǰ��min��Ϊmaxֱ������ֵΪ0Ϊֹ����ѭ��
			 */
			int temp = max % min;
			max = min;
			min = temp;
		}
		return min;
	}

	// a��b����С������
	public static int gongbei(int min, int max) {
		// �󹫱������ǽ���������˳������Լ��
		return min * max / gongyue(min, max);
	}

}