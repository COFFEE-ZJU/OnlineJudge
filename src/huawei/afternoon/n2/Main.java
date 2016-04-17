package huawei.afternoon.n2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static List<Integer> array = new ArrayList<Integer>();
	private static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o2, o1);
		}
	};
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextLine()){
			String line = cin.nextLine();
			int tmp = 0;
			boolean hasPrev = false, isNeg = false;;
			array.clear();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if (c < '0' || c > '9') {
					if(hasPrev)
						array.add(isNeg ? -tmp : tmp);
					tmp = 0;
					hasPrev = false;
					isNeg = c == '-';
					continue;
				}
				
				hasPrev = true;
				tmp = tmp * 10 + (c - '0');
			}
			if (hasPrev) array.add(tmp);
			
			Collections.sort(array, comp);
			
			sb.setLength(0);
			for (int n : array) {
				sb.append(n).append(' ');
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
	
//	public static void main(String args[]){
//		Scanner cin = new Scanner(System.in);
//		while (cin.hasNextLine()){
//			String[] line = cin.nextLine().split("[^0-9]");
//			
//			array.clear();
//			for (String w : line) {
//				if (!w.isEmpty())
//					array.add(Integer.valueOf(w));
//			}
//			
//			if (array.isEmpty()) 
//				continue;
//			
//			Collections.sort(array, comp);
//			
//			sb.setLength(0);
//			for (int n : array) {
//				sb.append(n).append(' ');
//			}
//			sb.setLength(sb.length()-1);
//			System.out.println(sb.toString());
//		}
//	}
}
