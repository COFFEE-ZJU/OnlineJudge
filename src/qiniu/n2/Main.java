package qiniu.n2;

import java.util.Arrays;
import java.util.Scanner;

class Num implements Comparable<Num> {
	final String num;

	public Num(String num) {
		this.num = num;
	}

	@Override
	public int compareTo(Num o) {
		return (o.num + num).compareTo(num + o.num);
	}
}

public class Main {

	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String[] ns = scanner.nextLine().split(",");
			int len = ns.length;
			Num[] nums = new Num[len];
			for (int i = 0; i < len; i++) {
				nums[i] = new Num(ns[i]);
			}
			Arrays.sort(nums);
			StringBuilder sb = new StringBuilder();
			for (Num num : nums) sb.append(num.num);

			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
