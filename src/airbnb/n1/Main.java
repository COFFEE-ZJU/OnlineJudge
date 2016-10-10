package airbnb.n1;

import java.util.*;

public class Main {
	private static class House {
		final int hostId;
		final String info;

		private House(String info) {
			this.info = info;
			hostId = Integer.parseInt(info.split(",")[0]);
		}
	}

	public String[] paginate(int resultsPerPage, String[] results) {
		List<House> delayed = new LinkedList<>();
		List<String> res = new ArrayList<>();
		Set<Integer> curHosts = new HashSet<>();
		int len = results.length;

		for (int i = 0; i < len || !delayed.isEmpty(); ) {
			curHosts.clear();
			int j = 0;
			for (Iterator<House> it = delayed.iterator(); it.hasNext() && j < resultsPerPage;) {
				House h = it.next();
				if (curHosts.add(h.hostId)) {
					it.remove();
					res.add(h.info);
					j++;
				}
			}

			while (i < len && j < resultsPerPage) {
				House h = new House(results[i++]);
				if (curHosts.add(h.hostId)) {
					res.add(h.info);
					j++;
				} else {
					delayed.add(h);
				}
			}

			while (j < resultsPerPage && !delayed.isEmpty()) {
				res.add(delayed.remove(0).info);
				j++;
			}

			res.add("");
		}

		res.remove(res.size()-1);
		return res.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String[] res = new Main().paginate(5, new String[]{
//				"1,28,300.1,SanFrancisco",
//				"4,5,209.1,SanFrancisco",
//				"20,7,208.1,SanFrancisco",
//				"23,8,207.1,SanFrancisco",
//				"16,10,206.1,Oakland",
//				"1,16,205.1,SanFrancisco",
//				"6,29,204.1,SanFrancisco",
//				"7,20,203.1,SanFrancisco",
//				"8,21,202.1,SanFrancisco",
//				"2,18,201.1,SanFrancisco",
//				"2,30,200.1,SanFrancisco",
//				"15,27,109.1,Oakland",
//				"10,13,108.1,Oakland",
//				"11,26,107.1,Oakland",
//				"12,9,106.1,Oakland",
//				"13,1,105.1,Oakland",
//				"22,17,104.1,Oakland",
//				"1,2,103.1,Oakland",
//				"28,24,102.1,Oakland",
//				"18,14,11.1,SanJose",
//				"6,25,10.1,Oakland",
//				"19,15,9.1,SanJose",
//				"3,19,8.1,SanJose",
//				"3,11,7.1,Oakland",
//				"27,12,6.1,Oakland",
//				"1,3,5.1,Oakland",
//				"25,4,4.1,SanJose",
//				"5,6,3.1,SanJose",
//				"29,22,2.1,SanJose",
//				"30,23,1.1,SanJose"
				
				"1,1",
				"4,2",
				"20,3",
				"6,4",
				"6,5",
				"1,6",
				"6,7",
				"7,8",
				"6,9",
				"2,10",
				"2,11",
				"3,12",
				"2,13",

		});

		for (String r : res) System.out.println(r);
	}
}
