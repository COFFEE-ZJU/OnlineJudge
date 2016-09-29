package baidu.n2;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
	private static class Task implements Comparable<Task> {
		int arrv, run;

		private Task(int arrv, int run) {
			this.arrv = arrv;
			this.run = run;
		}

		@Override
		public int compareTo(Task o) {
			return Integer.compare(arrv, o.arrv);
		}
	}
	public double avgWaitTime(int[] arrival, int[] run, int q) {
		int len = arrival.length;
		Task[] tasks = new Task[len];
		for (int i = 0; i < len; i++) {
			tasks[i] = new Task(arrival[i], run[i]);
		}

		Deque<Task> queue = new LinkedList<>();
		int curTime = tasks[0].arrv;
		int totalWaitTime = 0;
		int idx = 1;
		queue.addLast(tasks[0]);
		while (!queue.isEmpty() || idx < len) {
			if (queue.isEmpty()) {
				queue.addLast(tasks[idx]);
				curTime = tasks[idx++].arrv;
			}
			Task task = queue.pollFirst();
			totalWaitTime += (curTime - task.arrv);

			int delta = Math.min(q, task.run);
			task.run -= delta;
			curTime += delta;

			if (idx < len && curTime >= tasks[idx].arrv) {
				queue.addLast(tasks[idx++]);
			}

			if (task.run != 0) {
				task.arrv = curTime;
				queue.addLast(task);
			}
		}

		return 1.0 * totalWaitTime / len;
	}

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.avgWaitTime(new int[]{0, 1, 4},
				new int[]{5, 2, 3}, 3));

		System.out.println(main.avgWaitTime(new int[]{0, 1, 3, 9},
				new int[]{2, 1, 7, 5}, 2));
	}
}