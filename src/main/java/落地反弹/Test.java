package 落地反弹;

public class Test {

	public static void main(String[] args) {
		double len = 100; //距离地面高度
		int count = 10;//反弹次数
		double sum = 0 ; //总长度
		for (int i = 1; i <= count; i++) {
			sum+=len;
			len = len/2;
			System.out.println("每次反弹的高度："+len);
		}
		System.out.println("总长度："+sum);
	}
}