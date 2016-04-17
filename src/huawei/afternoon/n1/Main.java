package huawei.afternoon.n1;

import java.util.Scanner;

public class Main {
	public static long trans(int num, int r) {
		if (num == 0) return 0;
		boolean neg = num < 0;
		if (neg) num = -num;
		
		long res = 0;
		long tmp = 1;
		while (num != 0) {
			res += tmp * (num % r);
			num /= r;
			tmp *= 10;
		}
		
		return neg ? -res : res;
	}
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int num, r;
		while (cin.hasNext()){
			String[] line = cin.next().split(",");
			
			num = Integer.valueOf(line[0]);
			r = Integer.valueOf(line[1]);
			System.out.println(trans(num, r));
		}
	}
}
