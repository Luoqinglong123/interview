package 求和;

���;

import java.util.Scanner;

/**
 * ��Ŀ����s=a+aa+aaa+aaaa+aa...a��ֵ������a��һ�����֡�����2+22+222+2222+22222(��ʱ����5�������)��
 * a�Լ��ۼ�����λ���ǴӼ��̽��ա� ���������
 *  1�� ���մӼ��������һ����������ֻ����1-9֮������� 
 *  2�� ����һ������ʾ�ۼ�����λ��
 * 3.���磬����һ��4���ۼ�����λ��������������a��ֵ��5��s=5+55+555+5555 4.����һ��5��s=a+aa+aaa+aaaa+aaaaa
 * ��һ��д��
 */
public class Demo2 {

    public static void main(String[] args) {
            //����ֵһ��ɨ�����ı���
                Scanner input =new Scanner(System.in);
                System.out.println("����������������1-9��");
                int n=input.nextInt();
                System.out.println("����������Ĵ�����");
                int num=input.nextInt();
                //����ÿ��ѭ�����м������������ÿ�ε���
                double nums=0.0;
                //������ܺ�
                double sum=0.0;
                for (int i = 0; i < num; i++) {
                    //ÿ�ε�������NΪ�µ�n��ֵ
                    nums+=n;
                    //�ܺ�
                    sum+=nums;
                    //n��ֵÿ������ һλ
                    n=n*10;
                    System.out.println("ÿ�ε����������:"+nums);
                }
                System.out.println("�����ܺ��ǣ�"+sum);
    }

}