package 求和;

import java.util.Scanner;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，
 * a以及累加数的位数是从键盘接收。 程序分析：
 *  1、 接收从键盘输入的一个数（数字只能是1-9之间的数）
 *  2、 接收一个数表示累加数的位数
 * 3.例如，输入一个4（累加数的位数），键盘输入a的值是5：s=5+55+555+5555 4.输入一个5：s=a+aa+aaa+aaaa+aaaaa
 * 第一种写法
 */
public class Demo2 {

    public static void main(String[] args) {
        //声明值一个扫描器的变量
        Scanner input =new Scanner(System.in);
        System.out.println("请输入参与运算的数1-9：");
        int n=input.nextInt();
        System.out.println("请输入运算的次数：");
        int num=input.nextInt();
        //定义每次循环的中间变量用来计算每次的数
        double nums=0.0;
        //最后听总和
        double sum=0.0;
        for (int i = 0; i < num; i++) {
            //每次的数加上N为新的n的值
            nums+=n;
            //总和
            sum+=nums;
            //n的值每次增加 一位
            n=n*10;
            System.out.println("每次的运算的数是:"+nums);
        }
        System.out.println("最后的总和是："+sum);
    }

}