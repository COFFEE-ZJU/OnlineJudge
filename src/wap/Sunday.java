package wap;

public class Sunday {
	
	public int strMatch(String str, String pat){
		if(str == null || pat == null || str.length() == 0 || pat.length() == 0)
			return 0;
		
		char[] cStr = str.toCharArray(), cPat = pat.toCharArray();
		int[] posMap = new int[128];
		
		for(int i = 0; i < cPat.length; i++)
			posMap[cPat[i]] = i;
		
		int i = 0, j = 0, start = i;
		while(i < cStr.length && j < cPat.length){
			if(cStr[i] == cPat[j]){
				i++;
				j++;
			}
			else {
				i = i + cPat.length - j;
				if(i >= cStr.length)
					return -1;
				int pos = posMap[cStr[i]];
				if(pos == 0){	//miss
					j = 0;
					start = i;
				}
				else {
					i = i - pos;
					j = 0;
					start = i;
				}
			}
			
			System.out.println("i = "+i+", j = "+j);
		}
		
		if(j == cPat.length)
			return start;
		else 
			return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Sunday().strMatch("aaaaaaaaaaaaaaaaa", "aaaaea"));
	}
}
