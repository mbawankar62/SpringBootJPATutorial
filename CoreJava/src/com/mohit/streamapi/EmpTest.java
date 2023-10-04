package com.mohit.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmpTest {

	public static void main(String[] args) {
		
		//Employee e1 = new Employee(1,"Mohit",10000,28, new Date(2011-10-03));
		Employee e1 = new Employee(1,"Mohit Bawankar",10000,28,"male");
		Employee e2 = new Employee(2,"Rohit Shamji Bhandare",50000,25,"male");
		Employee e3 = new Employee(3,"Gohit Hajare",80000,30,"male");
		Employee e4 = new Employee(4,"Anant Pandey",30000,29,"male");
		Employee e5 = new Employee(4,"Anankita",30000,29,"Female");
		
		
		List<Employee> list = new ArrayList<>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(new Employee(5,"Shraddha",150000,26,"female"));
		list.add(new Employee(6,"Shraddha V",80000,26,"female"));
		
		System.out.println("Employee before sorting : " +list);
		System.out.println("--------------------Employee before sorting End -------------------- ");
		
		System.out.println("--------------------Comparing without compare to Overriding--------------------");
		Comparator<Employee> comparing = Comparator.comparing(Employee::getAge);
		Collections.sort(list, comparing);
		list.forEach(System.out::println);
		
		//or
		list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);
	
		
		System.out.println("--------------------Comparing without compare to Overriding End ----------------");
		System.out.println("------------simple for each loop ----------------" );
		
		for(Employee emp : list) {
			System.out.println("Employee before sorting : " +emp);
		}
		
		System.out.println("-------Employee before sorting forEach method of stream-------");
		list.stream().forEach(System.out::println);

		System.out.println("-------Employee after sorting Collections.sort-------");
		Collections.sort(list);
		System.out.println("Employee after sorting : " +list);
		
		System.out.println("--------Employee after stream().sorted()-------");
		list.stream().sorted().forEach(System.out::println);
		
		//Filter
		
		List<Employee> filterList = list.stream().filter( e ->e.getSalary() >=50000).collect(Collectors.toList());
		System.out.println("Salary >50k after filter : " +filterList);
		System.out.println("----------Salary >50k after filter :------------");
		list.stream().filter( e ->e.getSalary() >=50000).forEach(System.out::println);
		System.out.println("Salary >50k Total count :" +list.stream().filter(e ->e.getSalary() >=50000).count());
		
	/*
	 List<Employee> tempList = empList.stream()
	              .filter(e -> "Manager".equalsIgnoreCase(e.getDesignation()) && e.getAge() > 30)
	              .collect(Collectors.toList());
	 tempList.forEach(e -> System.out.println("Designation :- " + e.getDesignation() + " , Age :- " + e.getAge()));
	*/
		
	//male emp with min salary
	Employee MaleEmpWithMinSal = list.stream().filter(e->e.getGender()=="male").collect(Collectors.minBy(Comparator.comparing(Employee::getSalary))).get();	
	System.out.println("---Male emp with minumun salary::---"+MaleEmpWithMinSal);	
	
	Set<Integer> set =list.stream().filter( e ->e.getSalary() >=50000).map(e ->e.getSalary()).
																			collect(Collectors.toSet());
	System.out.println("Salary >50k after filter--List to set:" +set);
		
//Sorting In Descending Order
List<Employee> sortedlist_Desc = list.stream().sorted((i1,i2)-> -i1.compareTo(i2)).collect(Collectors.toList());

System.out.println("----sortedlist_Desc------" +sortedlist_Desc);
//List<Employee> sortedlist = list.stream().sorted().collect(Collectors.toList());
		
List<Employee> sortedlist = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
//Map<String, List<Employee>> groupbyenamelist = list.stream().collect(Collectors.groupingBy(Employee::getName));
		
Map<String, Map<Integer, List<Employee>>> sortedlistGoupingby = list.stream().collect(Collectors.groupingBy(Employee::getName,
																Collectors.groupingBy(Employee::getAge)));
		
		System.out.println("Employees after sortedlistGoupingby name  : " +sortedlistGoupingby);
		System.out.println("Employees after sorting in descending  : " +sortedlist);
		
		//for below comparator is not required
		Optional<Integer> findFirst = list.stream().map(e->e.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("Employees 2nd Highest salary : " +findFirst);
		
		//This example demonstrates how to sort an Employee by salary in ascending order using Java 8 Stream APIs:
		System.out.println("-------Comparision base on age-----------");
		list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList()).forEach(System.out::println);
		
		/*
		Iterator<Employee> itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println("Employees after sorting : " +itr.next());
		}
		*/
		
		/*
		for(Employee emp: list)
		{
			
			System.out.println("Movies after sorting : " +emp);
			
		}
		*/	
		//function to sort according to lenght of string
		/*
		 *
		 */
		Comparator<String> c = (s1,s2)->{
									int l1 =s1.length();
									int l2 = s2.length();
									if(l1<l2) return -1;
									if(l1>l2) return 1;
									else return s1.compareTo(s2);
										};
		List<String> sortedListcc= list.stream().map(e->e.getName()).sorted(c).collect(Collectors.toList());
		System.out.println("sortedListcc:"+sortedListcc);
		//*/
	
		//flatmap demo 
				System.out.println("-----flatmap demo----");
				
				List<Integer> list1 = Arrays.asList(1,2,3);
				List<Integer> list2 = Arrays.asList(4,5,6);
				List<Integer> list3 = Arrays.asList(7,8,9);
				  
				List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
				 
				List<Integer> listOfAllIntegers = listOfLists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
				         
				System.out.println(listOfAllIntegers);
				
				System.out.println("-----Simple map demo----");
				
				List newlist1 = list.stream().map(e->e.getName()).collect(Collectors.toList());
				System.out.println("-----Simple map demo----::"+newlist1);
				
				//sort method
				 Collections.sort(list,(em1,em2)-> (em1.getAge() - em2.getAge()));
				 list.forEach(System.out::println);
				 
				 //sorted method
				 list.stream().sorted((o1,o2) -> o1.getSalary() - o2.getSalary())
				 					//.forEach(t1->System.out.println("sorted salary:"+t1));
				 					.forEach(System.out::println);
				 
		//minby 
		//https://www.techiedelight.com/collectors-minby-maxby-method-java/
		// get a person with the minimum income
		//list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);		 
		Employee min = list.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary))).get();
		
	    System.out.println("Employee with minimum Salary " + min);
	    // get a person with the maximum income
	    Employee max =  list.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))).get();
	    System.out.println("Employee with maximum Salary " + max);
	    
	   // get a person with the minimum income
	    Employee min1 = list.stream().collect(Collectors.minBy((x, y) -> x.getSalary() - y.getSalary())).get();
	    System.out.println("Employee with minimum min1 Salary " + min1);
	    // get a person with the maximum income
	    Employee max1= list.stream().collect(Collectors.maxBy((x, y) -> x.getSalary() - y.getSalary())).get();
	    System.out.println("Employee with maximum max1 Salary " + max1);
	    List<Employee> sortedDescOrder =
	    list.stream().sorted((Comparator.comparingInt(Employee::getSalary).reversed())).collect(Collectors.toList());
	    sortedDescOrder.forEach(employee -> System.out.println(employee));
	    
	    list.stream().filter(employee -> employee.getName().startsWith("J")).collect(Collectors.toList()).forEach(System.out::println);
        
	    Employee employee =
	            list.stream()
	                .reduce((employee1, employee2) ->employee1.getSalary() > employee2.getSalary() ? employee1 : employee2)
	                .get();
	   System.out.println("Employee having max salary us :: " + employee);
	   
		}
	
	
	
	
	
		
}

