package 四个不同的数字可以组成的三位数;

public class Main {

	public static void main(String[] args) {
		int t = 0 ,num = 0 ;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int j2 = 1; j2 < 5; j2++) {
					if(i!=j&&i!=j2&&j!=j2){
						num = i*100+j*10+j2;
						System.out.println("生成的数有："+num);
						t++;
					}

				}
			}
		}
		System.out.println("总共为："+t);
	}
}