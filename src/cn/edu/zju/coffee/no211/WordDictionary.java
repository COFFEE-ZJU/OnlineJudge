package cn.edu.zju.coffee.no211;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;


public class WordDictionary {
	HashMap<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
    // Adds a word into the data structure.
    public void addWord(String word) {
    	if(word == null) return;
    	Integer key = new Integer(word.length());
    	Set<String> set = map.get(key);
    	
    	if(set == null) set = new TreeSet<String>();
    	
    	set.add(word);
    	map.put(key, set);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if(word == null) return false;
    	Integer key = new Integer(word.length());
    	Set<String> set = map.get(key);
    	
    	if(set == null) return false;
    	
    	for(String entry: set){
    		if(sEqual(entry, word)) return true;
    	}
    	
    	return false;
    }
    
    private boolean sEqual(String str, String pattern){
    	if(str == null || pattern == null || str.length() != pattern.length()) return false;
    	char[] cstr = str.toCharArray(), cpattern = pattern.toCharArray();
    	
    	for(int i = 0; i < cstr.length; i++){
    		if(!(cpattern[i] == '.' || cstr[i] == cpattern[i])) return false;
    	}
    	
    	return true;
    }
    
    
    public static void main(String[] args) {
    	WordDictionary wordDictionary = new WordDictionary();
    	wordDictionary.addWord("bad");
    	wordDictionary.addWord("dad");
    	wordDictionary.addWord("mad");
    	System.out.println(wordDictionary.search("pad"));
    	System.out.println(wordDictionary.search("bad"));
    	System.out.println(wordDictionary.search(".ad"));
    	System.out.println(wordDictionary.search("b.."));
	}
}