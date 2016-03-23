package google.codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CodejamUtils {
	private CodejamUtils(){}
	private static long startTime = 0;
	
	private static final String pathPrefix = "resources/google/codejam/";
	
	private static String getFolderName(Class<?> caller){
		String[] tmp = caller.getPackage().getName().split("\\.");
		
		return tmp[tmp.length - 1];
	}
	
	public static Scanner getScanner(String filePrefix, Class<?> caller) throws FileNotFoundException{
		String folder = getFolderName(caller);
		
		return new Scanner(new File(pathPrefix+folder+"/"+filePrefix+".in"));
	}
	
	public static Writer getWriter(String filePrefix, Class<?> caller) throws IOException{
		String folder = getFolderName(caller);
		
		return new FileWriter(new File(pathPrefix+folder+"/"+filePrefix+".out"));
	}
	
	public static void timerStart(){
		startTime = System.currentTimeMillis();
	}
	
	public static void timerStop(){
		int length = (int)(System.currentTimeMillis() - startTime);
		int milli = length % 1000;
		length /= 1000;
		int sec = length % 60;
		length /= 60;
		int min = length;
		System.out.println(String.format("time cost: %d min %d sec %d mills", min, sec, milli));
	}
	
//	public static void main(String[] args) {
//		getScanner("test", CodejamIOUtil.class);
//	}
}
