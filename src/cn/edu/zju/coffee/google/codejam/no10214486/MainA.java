package cn.edu.zju.coffee.google.codejam.no10214486;

import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import cn.edu.zju.coffee.google.codejam.CodejamUtils;

/**
 * https://code.google.com/codejam/contest/10214486/dashboard#s=p0
 * @author zkf
 *
 */
public class MainA {
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = CodejamUtils.getScanner("A-large-practice", MainA.class);
		Writer writer = CodejamUtils.getWriter("A-large-practice", MainA.class);
		
		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt ++){
			System.out.println("case "+tt);
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			City[] cities = new City[n];
			for(int i = 0; i < n; i++)
				cities[i] = new City(i);
			
			for(int mm = 0; mm < m; mm++){
				int sc = scanner.nextInt()-1, dc = scanner.nextInt()-1;
				int[] len = new int[24];
				for(int i = 0; i < 24; i++)
					len[i] = scanner.nextInt();
				
				City.addPath(sc, dc, len, cities);
			}
			
			writer.write("Case #"+(tt+1)+":");
			for(int kk = 0; kk < k; kk++){
				int dc = scanner.nextInt() - 1;
				int startTime = scanner.nextInt();
				writer.write(" "+City.fewestHours(dc, startTime, cities));
			}
			
			writer.write("\n");
		}
		
		writer.close();
		scanner.close();
	}
}

class Path{
	int destCity;
	int[] len;
	
	public Path(int destCity, int[] len) {
		if(len == null || len.length != 24)
			throw new IllegalArgumentException();
		this.destCity = destCity;
		this.len = len;
	}
}

class City{
	int no;		//start from 0
	List<Path> paths;
	int curTime;
	int hourSpent;
	
	City(int cityNo){
		no = cityNo;
		paths = new LinkedList<Path>();
	}
	
	static int fewestHours(int destCity, int startTime, City[] cities){
		System.out.println("Query: "+destCity+" "+startTime);
		return fewestHours(0, destCity, startTime, cities);
	}
	
	static int fewestHours(int startCity, int destCity, int startTime, City[] cities){
		if(startCity == destCity)
			return 0;
		
		for(City c : cities){
			c.curTime = -1;
			c.hourSpent = Integer.MAX_VALUE;
		}
		cities[startCity].curTime = startTime;
		cities[startCity].hourSpent = 0;
		
		TreeSet<City> treeSet = new TreeSet<City>(new Comparator<City>() {

			@Override
			public int compare(City o1, City o2) {
				if(o1.hourSpent == o2.hourSpent)
					return o1.no - o2.no;
				else
					return o1.hourSpent - o2.hourSpent;
			}
		});
		
		for(City c: cities)
			treeSet.add(c);
		
		while(true){
			City city = treeSet.first();
			if(city.hourSpent == Integer.MAX_VALUE)
				return -1;
			
			treeSet.remove(city);
			if(city.no == destCity)
				return city.hourSpent;
			
			for(Path p : city.paths){
				City dc = cities[p.destCity];
				if(! treeSet.contains(dc))
					continue;
				
				int pathTime = p.len[city.curTime];
				int hourSpent = city.hourSpent + pathTime;
				if(hourSpent >= dc.hourSpent)
					continue;
				
				int curTime = (city.curTime + pathTime) % 24;
				treeSet.remove(dc);
				dc.curTime = curTime;
				dc.hourSpent = hourSpent;
				treeSet.add(dc);
			}
		}
	}
	
	static void addPath(int a, int b, int[] len, City[] cities){
		cities[a].paths.add(new Path(b, len));
		cities[b].paths.add(new Path(a, len));
	}
}
