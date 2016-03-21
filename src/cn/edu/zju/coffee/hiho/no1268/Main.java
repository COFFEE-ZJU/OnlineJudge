package cn.edu.zju.coffee.hiho.no1268;

import java.util.Scanner;

public class Main {
	public static boolean solve(int[][] matrix) {
		matrix[1][1] = 5;
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1) continue;
					if (matrix[i][j] != 0 && matrix[2-i][2-j] == 0) {
						changed = true;
						matrix[2-i][2-j] = 10 - matrix[i][j];
					}
				}
				if (i == 2) continue;

				if (matrix[i][0] == 0 && matrix[i][1] != 0 && matrix[i][2] != 0) {
					changed = true; matrix[i][0] = 15 - matrix[i][1] - matrix[i][2];
				}
				if (matrix[i][0] != 0 && matrix[i][1] == 0 && matrix[i][2] != 0) {
					changed = true; matrix[i][1] = 15 - matrix[i][0] - matrix[i][2];
				}
				if (matrix[i][0] != 0 && matrix[i][1] != 0 && matrix[i][2] == 0) {
					changed = true; matrix[i][2] = 15 - matrix[i][1] - matrix[i][0];
				}
				if (matrix[0][i] == 0 && matrix[1][i] != 0 && matrix[2][i] != 0) {
					changed = true; matrix[0][i] = 15 - matrix[1][i] - matrix[2][i];
				}
				if (matrix[0][i] != 0 && matrix[1][i] == 0 && matrix[2][i] != 0) {
					changed = true; matrix[1][i] = 15 - matrix[0][i] - matrix[2][i];
				}
				if (matrix[0][i] != 0 && matrix[1][i] != 0 && matrix[2][i] == 0) {
					changed = true; matrix[2][i] = 15 - matrix[1][i] - matrix[0][i];
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] == 0) return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = new int[3][3];
		while (scanner.hasNextInt()) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			if (solve(matrix)) {
				for (int[] line : matrix) {
					System.out.println(line[0] + " " + line[1] + " " +line[2]);
				}
			}
			else
				System.out.println("Too Many");
		}

		scanner.close();
	}
}
