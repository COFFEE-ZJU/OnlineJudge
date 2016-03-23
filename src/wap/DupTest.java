package wap;

public class DupTest {
	public String longestDupString(String str){
		if(str == null || str.length() == 0) return "";
		
		int s = 0, e = 1;
		int maxS = 0, maxE = 0;
		
		while(e < str.length()){
			String sub = str.substring(s, e);
			
			if(str.substring(e).contains(sub)){
				maxS = s; maxE = e;
			}
			else
				s++;
			
			e++;
		}
		
		return str.substring(maxS, maxE);
	}
	
	public static void main(String[] args) {
		System.out.println(new DupTest().longestDupString("abcdaccsscda"));
	}
}
