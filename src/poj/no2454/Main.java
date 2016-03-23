package poj.no2454;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		List<Unit> all = new ArrayList<Unit>();
		Unit[] dist1 = new Unit[k];
		Unit[] dist2 = new Unit[k];
		int sum1 = 0, sum2 = 0;
		for(int i=0; i<3*k; i++){
			Unit unit = new Unit();
			unit.idx = i+1;
			unit.num = scanner.nextInt();
			all.add(unit);
		}
		Collections.sort(all, Unit.comparator);
//		Collections.reverse(all);
		for(int i=0; i<k; i++){
			Unit d1 = all.get(2*i);
			Unit d2 = all.get(2*i+1);
			dist1[i] = d1;
			dist2[i] = d2;
			sum1 += d1.num;
			sum2 += d2.num;
		}
		
		Random ran = new Random(System.currentTimeMillis());
		while(sum1 <= 500 * k || sum2 <= 500 * k){
			int r1 = ran.nextInt(k);
			int r2 = ran.nextInt(k);
			Unit d1 = dist1[r1], d2 = dist2[r2];
			int diff = d1.num - d2.num;
			dist1[r1] = d2;
			dist2[r2] = d1;
			sum1 -= diff;
			sum2 += diff;
		}
		
		for(Unit u: dist1)
			System.out.println(u.idx);
		for(Unit u: dist2)
			System.out.println(u.idx);
		for(int i=2*k; i<3*k; i++)
			System.out.println(all.get(i).idx);
	}
}

class Unit{
	int idx;
	int num;
	
	static final Comparator<Unit> comparator = new Comparator<Unit>() {
		
		@Override
		public int compare(Unit o1, Unit o2) {
			return o2.num - o1.num;
		}
	};
}
