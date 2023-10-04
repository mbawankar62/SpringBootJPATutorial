package com.mohit.corejava.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapKeyValue {

	public static void main(String[] args) {
		
		Student s1 = new Student("Ram", "1", "Tennis");
        Student s2 = new Student("John", "3", "Caroms");
        Student s3 = new Student("John", "1", "Tennis");
        Student s4 = new Student("Neha", "3", "Caroms");
        Student s5 = new Student("Ram", "4", "Cricket");
        Student s6 = new Student("Ram", "2", "Chess");
        Student s7 = new Student("Ram", "2", "Chess");
          
        /*List<Student> l = new ArrayList<Student>(Arrays.asList(s1,s2,s3,s4,s5,s6));
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>(); 
        
        for(Student s : l) {            
            if (hm.containsKey(s.name)) {
                hm.get(s.name).add(s.sportId+"-"+s.sport);
            } else {
                hm.put(s.name, new ArrayList<String>());
                hm.get(s.name).add(s.sportId+"-"+s.sport);
            }
        }
        System.out.println(hm);*/
        
        HashMap<String, Student> hm = new HashMap<String, Student>();
        hm.put("e1", s1);
        hm.put("e2", s2);
        hm.put("e3", s3);
        hm.put("e4", s4);
        hm.put("e5", s5);
        hm.put("e6", s6);
        hm.put("e7", s7);
        hm.put("e7", s7);
        //System.out.println(hm);
        for(Map.Entry<String, Student> entry : hm.entrySet()) {
        	
        	System.out.println(entry);
        }
        
	}

}

class Student {
	
	String name;
	String sport;
	String sportId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSportId() {
		return sportId;
	}

	public void setSportId(String sportId) {
		this.sportId = sportId;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	Student(String name, String sportId, String sport) {
		this.name = name;
		this.sportId = sportId;
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sport=" + sport + ", sportId=" + sportId + "]";
	}

}
