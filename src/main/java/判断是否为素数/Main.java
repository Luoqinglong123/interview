package 判断是否为素数;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断101-200之间有多少素数，并输出所有
 *
 * @author qinglongl
 *
 */
public class Main {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 101; i < 201; i++) {
			list.add(i);
		}
		for (int i = 101; i < 201; i++) {
			for (int j = 2; j < i/2; j++) {
				if (i % j == 0) {
					int k = list.indexOf(i);
					if(k!=-1)
						list.remove(k);
					continue;
				}
			}

		}
		System.out.print("所有的素数为");
		for (Integer integer : list) {
			System.out.print(integer+"\t");

		}
	}
}