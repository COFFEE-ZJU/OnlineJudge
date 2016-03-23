package google.codejam.no4284486;

import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import google.codejam.CodejamUtils;

public class MainC {
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("C-large-practice", MainC.class);
		Writer writer = CodejamUtils.getWriter("C-large-practice", MainC.class);
//		Scanner scanner = CodejamUtils.getScanner("c-test", MainC.class);
//		Writer writer = CodejamUtils.getWriter("c-test", MainC.class);
		
		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			writer.write("Case #"+(tt+1)+":\n");
			System.out.println("case "+tt);
			
			int n = scanner.nextInt(), m = scanner.nextInt();
			Citys citys = new Citys(n);
			for(int i = 0; i < m; i ++)
				citys.addRoad(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			
			for(Road r : citys.getInefficientRoads())
				writer.write(r.roadNo + "\n");
		}
		
		scanner.close();
		writer.close();
	}
}

class Road{
	static int counter = 0;
	
	static Comparator<Road> comparator = new Comparator<Road>() {
		
		@Override
		public int compare(Road o1, Road o2) {
			return o1.roadNo - o2.roadNo;
		}
	};
	
	int roadNo;
	int city1;
	int city2;
	int length;
	
	public Road(int city1, int city2, int length) {
		roadNo = counter ++;
		
		if(city1 <= city2){
			this.city1 = city1;
			this.city2 = city2;
		}
		else {
			this.city2 = city1;
			this.city1 = city2;
		}
		this.length = length;
	}
	
//	@Override
//	public boolean equals(Object obj){
//		if(! (obj instanceof Road)) return false;
//		else return hashCode() == obj.hashCode();
//	}
//	
//	@Override
//	public int hashCode(){
//		return String.format("%d %d %d", city1, city2, length).hashCode();
//	}
}

class City{
	int cityNo;
	List<Road> roads;
	
	int length;
	List<Road> lastRoads;
	static Comparator<City> comparator = new Comparator<City>() {
		@Override
		public int compare(City o1, City o2) {
			if(o1.length == o2.length)
				return o1.cityNo - o2.cityNo;
			else
				return o1.length - o2.length;
		}
	};
	
	public City(int cityNo) {
		this.cityNo = cityNo;
		this.roads = new LinkedList<Road>();
		this.lastRoads = new LinkedList<Road>();
	}
	
	void addRoad(Road road){
		roads.add(road);
	}
}

class Citys{
	int cityNum;
	City[] cities;
	List<Road> roads;
	
	public Citys(int cityNum) {
		Road.counter = 0;
		
		this.cityNum = cityNum;
		cities = new City[cityNum];
		for(int i = 0; i < cityNum; i++)
			cities[i] = new City(i);
		this.roads = new LinkedList<Road>();
	}
	
	void addRoad(int city1, int city2, int len){
		Road road = new Road(city1, city2, len);
		roads.add(road);
		cities[city1].addRoad(road);
		cities[city2].addRoad(road);
	}
	
	TreeSet<Road> getInefficientRoads(){
		TreeSet<Road> inefficientRoads = new TreeSet<Road>(Road.comparator);
		inefficientRoads.addAll(roads);
		
		TreeSet<City> set = new TreeSet<City>(City.comparator);
		for(int city = 0; city < cityNum; city ++){
			for(int i = 0; i < cityNum; i ++){
				if(i == city)
					cities[i].length = 0;
				else
					cities[i].length = Integer.MAX_VALUE;
				
				cities[i].lastRoads.clear();
				
				set.add(cities[i]);
			}
			
			while(!set.isEmpty()){
				City dc = set.first();
				set.remove(dc);
				inefficientRoads.removeAll(dc.lastRoads);
				
				int curLen = dc.length;
				for(Road r : cities[dc.cityNo].roads){
					int nextCity = dc.cityNo == r.city1 ? r.city2 : r.city1;
					City nc = cities[nextCity];
					int len = curLen + r.length;
					
					if(len == nc.length)
						nc.lastRoads.add(r);
					else if(len < nc.length){
						set.remove(nc);
						nc.lastRoads.clear();
						nc.lastRoads.add(r);
						nc.length = len;
						set.add(nc);
					}
				}
			}
		}
		
		return inefficientRoads;
	}
}