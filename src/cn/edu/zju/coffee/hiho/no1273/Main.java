package cn.edu.zju.coffee.hiho.no1273;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static class Poster {
		int x0, y0, x1, y1, id, count = 1;
		boolean[] cornerCovered = new boolean[4];
		List<Poster> covers = new LinkedList<>();

		public Poster(int x0, int y0, int x1, int y1, int id) {
			this.x0 = x0;
			this.y0 = y0;
			this.x1 = x1;
			this.y1 = y1;
			this.id = id;
		}

		boolean isCoveredBy(Poster other) {
			boolean covered = !(other.x1 <= x0 || other.y1 <= y0 || other.x0 >= x1 || other.y0 >= y1);
			if (!covered) return false;

			if (!cornerCovered[0]) cornerCovered[0] = other.isPointInside(x0, y0);
			if (!cornerCovered[1]) cornerCovered[1] = other.isPointInside(x0, y1);
			if (!cornerCovered[2]) cornerCovered[2] = other.isPointInside(x1, y0);
			if (!cornerCovered[3]) cornerCovered[3] = other.isPointInside(x1, y1);

			return true;
		}

		boolean isPointInside(int x, int y) {
			return (x > x0 && x < x1 && y > y0 && y < y1);
		}

		boolean rippable() {
			for (boolean c : cornerCovered)
				if (!c) return true;

			return false;
		}
	}

	private Poster[] posters;
	private int len;

	public Main(Poster[] posters) {
		this.posters = posters;
	}

	private Poster solve() {
		if (posters == null || (len = posters.length) == 0)
			return null;

		boolean[] processed = new boolean[len];
		List<Poster> linkProcess = new LinkedList<>();
		for (int i = 1; i < len; i++) {
			Arrays.fill(processed, false);
			linkProcess.clear();
			Poster cur = posters[i];
			for (int j = i-1; j >= 0; j--) {
				if (posters[j].isCoveredBy(cur)) {
					processed[j] = true;
					cur.covers.add(posters[j]);
				}
			}
			linkProcess.addAll(cur.covers);
			while (!linkProcess.isEmpty()) {
				Poster poster = linkProcess.remove(0);
				poster.count++;
				for (Poster p : poster.covers) {
					if (!processed[p.id]) {
						processed[p.id] = true;
						linkProcess.add(p);
					}
				}
			}
		}

		Poster max = null;
		for (int i = 0; i < len; i++) {
			Poster p = posters[i];
			if (p.rippable() && (max == null || p.count > max.count))
				max = p;
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			scanner.nextInt();
			scanner.nextInt();
			int n = scanner.nextInt();
			Poster[] posters = new Poster[n];
			for (int i = 0; i < n; i++) {
				posters[i] = new Poster(scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt(), scanner.nextInt(), i);
			}
			Poster max = new Main(posters).solve();
			System.out.println(max.count + " " + (max.id+1));
		}

		scanner.close();
	}
}
