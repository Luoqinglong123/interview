package 正整数分解质因数;
import java.util.Scanner;

/**将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。*/
public class Topic14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        int num = sc.nextInt();
        //int num = 90;
        int k = 2;
        System.out.print(num + "=");//输出第一步格式
        while (num > k) {//初值k为2,num为输入的数字,在程序执行的过程中k渐渐变大(k++),n渐渐变小(num/k)
            if (num % k == 0) {
                System.out.print(k + "×");//如果num <> k，但n能被k整除，则应打印出k的值
                num = num / k;//num除以k的商,作为新的正整数num
            }else if (num % k != 0) {
                k++;
            }
        }
        System.out.println(k);
    }
}