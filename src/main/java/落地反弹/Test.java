package 落地反弹; ��ط���;

public class Test {

	public static void main(String[] args) {
		double len = 100; //�������߶�
		int count = 10;//��������
		double sum = 0 ; //�ܳ���
		for (int i = 1; i <= count; i++) {
			sum+=len;
			len = len/2;
			System.out.println("ÿ�η����ĸ߶ȣ�"+len);
		}
		System.out.println("�ܳ��ȣ�"+sum);
	}
}
