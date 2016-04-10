package hiho.no1291;

import java.util.*;

public class Main {
	// 0: init, 1: occupied, 2: freeSpace
	private static int[][][] space = new int[101][101][101];
	private static int xMax, yMax, zMax;

	private static void reset() {
		for (int i = 0; i <= xMax; i++) {
			for (int j = 0; j <= yMax; j++) {
				for (int k = 0; k <= zMax; k++) {
					space[i][j][k] = 0;
				}
			}
		}
	}

	private static boolean checkValueAdj(int x, int y, int z, int val) {
		if (space[x+1][y][z] == val || space[x][y+1][z] == val || space[x][y][z+1] == val)
			return true;
		return ((x > 0 && space[x-1][y][z] == val) ||
				(y > 0 && space[x][y-1][z] == val) ||
				(z > 0 && space[x][y][z-1] == val));

	}

	private static boolean validateAndBuild(int x, int y, int z) {
		if (space[x][y][z] == 1) return false;
		if (z == 0 || checkValueAdj(x, y, z, 1)) {
			space[x][y][z] = 1;
			return true;
		}

		return false;

	}

	private static List<Integer> xs = new ArrayList<Integer>();
	private static List<Integer> ys = new ArrayList<Integer>();
	private static List<Integer> zs = new ArrayList<Integer>();
	private static void dfsFree(int x, int y, int z) {
		xs.clear();ys.clear();zs.clear();
		xs.add(x);ys.add(y);zs.add(z);

		while (!xs.isEmpty()) {
			x = xs.remove(0);
			y = ys.remove(0);
			z = zs.remove(0);
			if (x < 0 || y < 0 || z < 0 ||
					x > xMax || y > yMax || z > zMax ||
					space[x][y][z] != 0) continue;

			space[x][y][z] = 2;
			xs.add(x-1);
			xs.add(x+1);
			xs.add(x);
			xs.add(x);
			xs.add(x);
			xs.add(x);

			ys.add(y);
			ys.add(y);
			ys.add(y-1);
			ys.add(y+1);
			ys.add(y);
			ys.add(y);

			zs.add(z);
			zs.add(z);
			zs.add(z);
			zs.add(z);
			zs.add(z-1);
			zs.add(z+1);
		}
	}

	private static boolean checkAndRemove(int x, int y, int z) {
		if (!checkValueAdj(x,y,z, 2))
			return false;

		space[x][y][z] = 0;
		dfsFree(x,y,z);
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int r = scanner.nextInt();
			for (int rr = 0; rr < r; rr++) {

				int n = scanner.nextInt();
				int[][] builds = new int[n][3];
				xMax = yMax = zMax = 0;
				for (int i = 0; i < n; i++) {
					int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
					xMax = Math.max(xMax, x);
					yMax = Math.max(yMax, y);
					zMax = Math.max(zMax, z);
					builds[i][0] = x - 1;
					builds[i][1] = y - 1;
					builds[i][2] = z - 1;

				}

				reset();
				boolean legal = true;
				for (int i = 0; i < n; i++) {
					if(!validateAndBuild(builds[i][0],builds[i][1],builds[i][2])) {
						legal = false;
						break;
					}
				}
				if (!legal) {
					System.out.println("No");
					continue;
				}

				dfsFree(xMax, yMax, zMax);
				for (int i = n-1; i >= 0 ; i--) {
					if (!checkAndRemove(builds[i][0], builds[i][1], builds[i][2])) {
						legal = false;
						break;
					}
				}

				System.out.println(legal ? "Yes" : "No");
			}
		}
	}

}
