package 兔子斐波那契数列;
import java.util.Scanner;

/**
 * @author ForeverLover
 *    斐波那契数列, Sn = Sn-1+Sn-2
 */
public class Rabbit {
    public static void main(String[] args) {
        long s1 = 1; //第一个月为1对
        long s2 = 1; //第二个月为1对
        int count;
        long temp;
        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            if (i == 1) {
                System.out.println("第" + i + "个月的兔子对数：" + s1);
            } else if (i == 2) {
                System.out.println("第" + i + "个月的兔子对数：" + s1);
            } else {
                temp = s2;
                s2 = s1 + s2;
                s1 = temp;
                System.out.println("第" + i + "个月的兔子对数：" + s2);
            }
        }
    }
}