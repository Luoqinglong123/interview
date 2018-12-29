package 从小到大输出;

��С�������;

import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(2);
		set.add(5);
		set.add(1);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
}
