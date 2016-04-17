package huawei.afternoon.n3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static class Point implements Comparable<Point>{
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		Point(String str) {
			String[] xy = str.split(",");
			this.x = Integer.valueOf(xy[0]);
			this.y = Integer.valueOf(xy[1]);
		}
		@Override
		public int compareTo(Point o) {
			int r1 = Integer.compare(x, o.x) ;
			if (r1 != 0) return r1;
			else return Integer.compare(y, o.y) ;
		}
		@Override
		public String toString(){
			return String.format("%d,%d", x,y);
		}
	}
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextLine()){
			String[] line = cin.nextLine().split(";");
			Point[] points = new Point[line.length-1];
			for (int i = 1; i < line.length; i++) {
				points[i-1] = new Point(line[i]);
			}
			Arrays.sort(points);
			int len = points.length;
			int xMin = points[0].x, xMax = points[len-1].x;
			
			List<Point> res = new LinkedList<Main.Point>();
			Point prev = points[0];
			res.add(prev);
			for (Point p : points) {
				if (p.x == xMin)
					prev = p;
				else
					break;
			}
			if (prev != points[0]) res.add(prev);
			
			while (true) {
				Double max = null;
				Point maxP = null;
				for (Point p : points) {
					if (p.x <= prev.x)
						continue;
					
//					System.out.println(String.format("p.y-prev.y: %d, p.x-prev.x: %d", p.y-prev.y, p.x-prev.x));
//					double tmp = BigDecimal.valueOf(p.y-prev.y).divide(BigDecimal.valueOf(p.x-prev.x));
					double tmp = 1.0 * (p.y-prev.y) / (p.x-prev.x);
					if (max == null || tmp >= max) {
						max = tmp;
						maxP = p;
					}
				}
				res.add(maxP);
				prev = maxP;
				if (maxP.x == xMax)
					break;
			}
			
			for (int i = len-1; i >= 0; i--) {
				Point p = points[i];
				if (p.x == xMax)
					prev = p;
				else
					break;
			}
			if (prev != points[len-1]) res.add(prev);
			
			while (true) {
				Double max = null;
				Point maxP = null;
				for (int i = len-1; i >= 0; i--) {
					Point p = points[i];
					if (p.x >= prev.x)
						continue;
//					BigDecimal tmp = BigDecimal.valueOf(p.y-prev.y).divide(BigDecimal.valueOf(p.x-prev.x));
					double tmp = 1.0 * (p.y-prev.y) / (p.x-prev.x);
					if (max == null || tmp >= max) {
						max = tmp;
						maxP = p;
					}
				}
				
				if (maxP.x == xMin)
					break;
				res.add(maxP);
				prev = maxP;
			}
			
			StringBuilder sb = new StringBuilder();
			for(Point p : res) {
				sb.append(p).append(';');
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
}
