package cn.edu.zju.coffee.leetcode.no030;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words == null || words.length == 0) return null;
        
        int len = words[0].length();
        int wordCnt = words.length;
        List<Integer> idx = new LinkedList<Integer>();
        Map<String, Integer> wordMap = new HashMap<String, Integer>(), tmpMap;
        for(String word: words){
        	Integer occur = wordMap.get(word);
        	if(occur == null)
        		wordMap.put(word, 1);
        	else
        		wordMap.put(word, occur+1);
        }
        
        for(int i = 0; i <= s.length() - wordCnt * len; i++){
        	tmpMap = new HashMap<String, Integer>(wordMap);
        	int cnt = 0, offset = 0;
        	while(cnt != wordCnt){
        		String curWord = s.substring(i+offset, i+offset+len);
        		Integer ocr = tmpMap.get(curWord);
        		if(ocr != null){
        			cnt ++;
        			offset += len;
        			if(ocr == 1)
        				tmpMap.remove(curWord);
        			else
        				tmpMap.put(curWord, ocr-1);
        		}
        		else break;
        	}
        	if(cnt == wordCnt) idx.add(i);
        }
        
        return idx;
    }
    
    public static void main(String[] args) {
		List<Integer> idx = new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
		for(int pos: idx){
			System.out.println(pos);
		}
	}
}