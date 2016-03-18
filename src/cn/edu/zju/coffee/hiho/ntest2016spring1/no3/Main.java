package cn.edu.zju.coffee.hiho.ntest2016spring1.no3;

import java.util.*;

public class Main {
	private static class Line implements Comparable<Line>{
		@Override
		public int compareTo(Line o) {
			return Integer.compare(start, o.start);
		}

		enum Type {VERT, HORI, P45, N45}
		private Type type;
		int start, cross, d;
		Line(int x0, int y0, int x1, int y1) {
			if (x0 == x1) {
				type = Type.VERT;
				this.cross = x0;
				this.start = Math.min(y0, y1);
				d = Math.abs(y0 - y1);
			}
			else if (y0 == y1) {
				type = Type.HORI;
				this.cross = y0;
				this.start = Math.min(x0, x1);
				d = Math.abs(x0 - x1);
			}
			else {
				int dx = x1-x0, dy = y1-y0;
				if (dx == dy) {
					type = Type.P45;
					this.start = Math.min(x0, x1);
					this.cross = y0-x0;
					d = dx;
				}
				else if (dx == -dy) {
					type = Type.N45;
					this.start = Math.min(x0, x1);
					this.cross = y0+x0;
					d = Math.abs(dx);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Map<Line.Type, Map<Integer, List<Line>>> typeMap = new HashMap<Line.Type, Map<Integer, List<Line>>>();
		typeMap.put(Line.Type.VERT, new HashMap<Integer, List<Line>>());
		typeMap.put(Line.Type.HORI, new HashMap<Integer, List<Line>>());
		typeMap.put(Line.Type.P45, new HashMap<Integer, List<Line>>());
		typeMap.put(Line.Type.N45, new HashMap<Integer, List<Line>>());

		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		for (int rr = 0; rr < r; rr++) {
			for (Map<Integer, List<Line>> map : typeMap.values())
				map.clear();

			int n = scanner.nextInt();
			for (int nn = 0; nn < n; nn++) {
				Line line = new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				Map<Integer, List<Line>> map = typeMap.get(line.type);
				List<Line> lines = map.get(line.cross);
				if (lines == null) {
					lines = new ArrayList<>();
					map.put(line.cross, lines);
				}
				lines.add(line);
			}

			for (Map<Integer, List<Line>> map : typeMap.values()) {
				for (List<Line> lines : map.values()) {
					Collections.sort(lines);
					int end = Integer.MIN_VALUE;
					for (Line line : lines) {
						if (line.start <= end) {
							n--;
							end = Math.max(end, line.start+line.d);
						}
						else {
							end = line.start + line.d;
						}
					}
				}
			}
			if (rr != 0)
				System.out.println();
			System.out.print(n);
		}
	}
}
