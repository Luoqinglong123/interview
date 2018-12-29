package 水仙花数

�ɻ���;

import java.util.ArrayList;

/*
 * 100-999
 */
public class Main {

	public static void main(String[] args) {
		int x, y, z;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 100; i < 999; i++) {
			x = i / 100;
			y = (i % 100) / 10;
			z = i % 10;
			if(i == x*x*x+y*y*y+z*z*z ){
				list.add(i);
			}
		}
		System.out.println("ˮ�ɻ�����");
		for (Integer integer : list) {
			System.out.print(integer+"\t");
		}
	}
}
