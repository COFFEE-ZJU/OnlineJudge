package cn.edu.zju.coffee.wap;

public class DupTest {
	public String longestDupString(String str){
		if(str == null || str.length() == 0) return "";
		
		int s = 0, e = 1;
		int maxS = 0, maxE = 0;
		
		while(e <= str.length()){
			String sub = str.substring(s, e);
			boolean b1 = false, b2 = false;
			if(s!=0)
				b1 = str.substring(0, s).contains(sub);
			if(e!=str.length())
				b2 = str.substring(e).contains(sub);
			if(b1 || b2){
				maxS = s; maxE = e;
			}
			else
				s++;
			
			e++;
		}
		
		return str.substring(maxS, maxE);
	}
	
	public static void main(String[] args) {
		System.out.println(new DupTest().longestDupString("aaaaa"));
	}
}
