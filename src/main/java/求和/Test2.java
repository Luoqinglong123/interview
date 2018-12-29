package 求和; ���;

public class Test2 {

	public static void main(String[] args) {
		int x = 2; // ����
		int y = 5; // ����
		int sum = 0;// �ܺ�
		int nums = 0;// ÿ�μ���õ���ֵ
		for (int i = 0; i < y; i++) {
			nums += x;
			sum += nums;
			System.out.println("ÿ����������ǣ�"+nums);
			x *= 10;
		}
		System.out.println("���������ǣ�"+sum);
	}
}
