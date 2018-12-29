package 一个整数加上100是个完全平方数����������100�Ǹ���ȫƽ����;

public class Main {

	public static void main(String[] args) {
		int i = 1;
		while (i < 100000) {
			if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 268) % 1 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
