package com.mohit.corejava.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnmodifiableList {

	public static void main (String args[]) {
		
		List<String> list = Arrays.asList("foo", "bar", "baz");
		//list.add("baz1");
		System.out.println("initialList::"+list);//Exception in thread "main" java.lang.UnsupportedOperationException
		System.out.println("****************************");
		
		List<String> list1 = new ArrayList<>();  
		list1.add("Java");  
		list1.add("JavaFX");  
		list1.add("Spring");  
		list1.add("Hibernate");  
		list1.add("JSP");  
        for(String l : list1){  
            System.out.println("forEachMethodl::"+l);
            //list1.add("JSP2"); //java.util.ConcurrentModificationException
        } 
        System.out.println("****************************");
        
        
        List<String> list2 = new ArrayList<>();  
        list2.add("Java");  
        list2.add("JavaFX");  
        list2.add("Spring");  
        list2.add("Hibernate");  
        list2.add("JSP");
		System.out.println("Before Addind element in List::"+list2);
		
		list2.add("JSP2");
		
		System.out.println("After Adding element in List::"+list2);
		
        List<String> immutablelist  = Collections.unmodifiableList(list2);
        System.out.println("aad jsp3 in list2");
        list2.add("JSP3");
        System.out.println("After unmodifiableList List but before immutablelist ::"+immutablelist );
        System.out.println("aad jsp4 in immutablelist");
        //immutablelist.add("JSP4");
        System.out.println("After unmodifiableList List::"+immutablelist );
        
        System.out.println("****************************");
        
        System.out.println("******adding while iterating*******");
        //List<String> Fruitlist=new ArrayList<String>();
       List<String> Fruitlist=new CopyOnWriteArrayList<String>();
        Fruitlist.add("Mango");    
        Fruitlist.add("Apple");    
        Fruitlist.add("Banana");    
        Fruitlist.add("Grapes");    
        
        Iterator<String> itr=Fruitlist.iterator();
        System.out.println("----adding New Grape while iterating------");
        Fruitlist.add("New Grapes");
        
        //first iteration done on snapshot
        while(itr.hasNext()){  
         
         System.out.println(itr.next()); 
        
        }
        
        // iterator after adding an element
        itr = Fruitlist.iterator();
        System.out.println("-------List contains:-----------");
        while (itr.hasNext()) {
            System.out.println(itr.next());
    }
        System.out.println("-------factory collections of():-----------");
        List<String> Oflist = List.of("Java","JavaFX","Spring","Hibernate","JSP");
        //Oflist.add("new");
        System.out.println(Oflist);
        //Oflist.add("new java");
        for(String l:Oflist) {  
            System.out.println(l);  
        } 
        
	}
}
