package 正整数分解质因数;

�������ֽ�������;
import java.util.Scanner;

/**��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��*/
public class Topic14 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("������һ��������:");  
        int num = sc.nextInt();
        //int num = 90;
        int k = 2;
        System.out.print(num + "=");//�����һ����ʽ
        while (num > k) {//��ֵkΪ2,numΪ���������,�ڳ���ִ�еĹ�����k�������(k++),n������С(num/k)
            if (num % k == 0) {
                System.out.print(k + "��");//���num <> k����n�ܱ�k��������Ӧ��ӡ��k��ֵ
                num = num / k;//num����k����,��Ϊ�µ�������num
            }else if (num % k != 0) {
                k++;
            }
        }
        System.out.println(k);
    }
}