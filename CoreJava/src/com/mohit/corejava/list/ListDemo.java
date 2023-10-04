package com.mohit.corejava.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main (String args[]) {
		
		List<String>list = new ArrayList<>();
		list.add("1Mohit");
		list.add("2Bawankar");
		list.add("3Bawankar");
		list.add("2Bawankar");
		list.add(1, "4Baburao");
		
		System.out.println("List:-"+list);
		System.out.println("-----------------------------------");
		list.remove(1);
		
		//for-each loop
		for(String str:list) {
			System.out.println("List using for loop:-"+str);
		}
		System.out.println("-----------------------------------");
		
		//Iterator
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			
			System.out.println("Output after Iterator:-"+itr.next());
		}
		System.out.println("-----------------------------------");
		
		Collections.sort(list);
		for(String str1 : list) {
			System.out.println("list after sorting:-"+str1);
		}
		System.out.println("-----------------------------------");
		
		//for loop
		for(int i =0; i<list.size();i++) {
			System.out.println("list using for loop:"+list.get(i));
		}
		System.out.println("-----------------------------------");
		
		//forEach loop
		list.forEach(a->System.out.println("list using forEach:"+a));
		
		System.out.println("-----------------------------------");
		
		ListIterator<String> listItr= list.listIterator(list.size());
		while(listItr.hasPrevious()) {
			
			System.out.println("ListIterator:-"+listItr.previous());
		}
		
		System.out.println("-----------------------------------");
		
		list.stream().forEach(a->System.out.println("list using forEach:"+a));
		System.out.println("-----------------------------------");
		
		List<String> listsize = new ArrayList<>();
		System.out.println("empty arraylist size:"+listsize.size());
		listsize.add("1");
		System.out.println("arraylist size after adding one element:"+listsize.size());
		
		System.out.println("-----------------------------------");
	}
}
