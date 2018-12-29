package 求和;

public class Test2 {

	public static void main(String[] args) {
		int x = 2; // 数字
		int y = 5; // 次数
		int sum = 0;// 总和
		int nums = 0;// 每次计算得到的值
		for (int i = 0; i < y; i++) {
			nums += x;
			sum += nums;
			System.out.println("每次运算的数是："+nums);
			x *= 10;
		}
		System.out.println("运算结果数是："+sum);
	}
}