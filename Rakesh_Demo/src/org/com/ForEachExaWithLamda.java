package org.com;

import java.util.ArrayList;
import java.util.List;

public class ForEachExaWithLamda {
	
	public static void main(String args[]) {
		
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.add("jerry");
		
		list.forEach(
				(n)->System.out.println(n)
				);
	}

}
