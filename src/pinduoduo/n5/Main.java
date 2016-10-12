package pinduoduo.n5;

public class Main {
	public int minDistance(int[] a, int[] b) {
		int len;
		if (a == null || b == null || (len = a.length) != b.length) return -1;

		int maxMul = 0;
		int totalAdd = 0;
		for (int i = 0; i < len; i++) {
			int curMul = 0, curAdd = 0;
			int aa = a[i], bb = b[i];
			if (bb < aa) return -1;
			while (bb != aa) {
				if (aa > bb / 2) {
					curAdd += (bb - aa);
					break;
				}
				curAdd += bb % 2;
				bb /= 2;
				if (bb != 0) curMul++;
			}
			maxMul = Math.max(maxMul, curMul);
			totalAdd += curAdd;
		}

		return totalAdd + maxMul;
	}

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.minDistance(new int[]{1, 2, 3}, new int[]{2,4,6}));
		System.out.println(main.minDistance(new int[]{1, 0, 3}, new int[]{2,4,7}));
	}
}
