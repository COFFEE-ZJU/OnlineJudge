package leetcode.no071;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return "";
		String[] list = path.split("/");
		if (list.length == 0)
			return "/";

		List<String> paths = new LinkedList<>();

		for (int idx = 1; idx < list.length; idx++){
			if (list[idx].equals("") || list[idx].equals("."))
				continue;

			if (list[idx].equals("..")) {
				if (paths.size() > 0)
					paths.remove(paths.size() - 1);
			}
			else
				paths.add(list[idx]);
		}

		return "/" + String.join("/", paths);
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.simplifyPath(""));
		System.out.println(sol.simplifyPath("/"));
		System.out.println(sol.simplifyPath("//"));
		System.out.println(sol.simplifyPath("/home/"));
		System.out.println(sol.simplifyPath("//home///"));
		System.out.println(sol.simplifyPath("/home"));
		System.out.println(sol.simplifyPath("home/"));
		System.out.println(sol.simplifyPath("/.."));

	}
}