package 从小到大输出;

public class Test3 {

	public static void main(String[] args) {
		int x=2,y=1,z=5;
		int max = Math.max(Math.max(x,y),z);
		int min = Math.min(Math.min(x,y),z);
		int other = 0 ; 
		int[] array ={x,y,z};
		for (int i = 0; i < array.length; i++) {
			if(array[i]!=max&&array[i]!=min){
				other = array[i];
			}
		}
		System.out.println(min+"  "+other+"  "+max);
		
	}
}
