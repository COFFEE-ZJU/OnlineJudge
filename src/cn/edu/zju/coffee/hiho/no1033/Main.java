package cn.edu.zju.coffee.hiho.no1033;

public class Main {
	private static void calc() {
		int[][] countK = new int[19][201];
		countK[0][100] = 1;
		for (int i = 1; i < 19; i++) {
			for (int k = 0; k < 201; k++) {
				countK[i][k] = countK[i - 1][k];
				for (int j = 1; j < 10; j++) {
					int prevK = j-k+200;
					if (prevK >= 0 && prevK <= 200)
						countK[i][k] += countK[i-1][prevK];
				}
			}
		}
		for (int i = -10; i <= 10; i++) {
			System.out.print(i + ":");
			System.out.print(countK[0][i+100] + ", ");
			System.out.print(countK[1][i+100] + ", ");
			System.out.println(countK[2][i+100]);
		}
	}

	public static void main(String[] args) {
		calc();
//		try(Scanner scanner = new Scanner(System.in)) {
//			while (scanner.hasNextInt()) {
//				Main main = new Main();
//				int n = scanner.nextInt();
//				for (int i = 0; i < n; i++)
//					main.addWord(scanner.next());
//
//				int q = scanner.nextInt();
//				for (int i = 0; i < q; i++)
//					System.out.println(main.query(scanner.next()));
//			}
//		}
	}
}
