package 输入年月日判断第几天; �����������жϵڼ���;

public class Test1 {
	public static void main(String[] args) {
		int nian = 2014, yue = 3, ri = 4;
		int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
		if ((nian % 4 == 0 && nian % 100 != 0) || nian % 400 == 0) {
			day[1] = 29;
		}
		int sum = 0;
		for (int i = 0; i < yue - 1; i++) {
			sum += day[i];
		}
		sum += 4;
		System.out.println("����Ϊ��" + sum);
	}
}
