package com.hibernate.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.demo.entity.Student;

//https://www.javaguides.net/p/hibernate-tutorial.html
@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
		/*
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
	    Student student1 = new Student("John", "Cena", "john@javaguides.com");
	    Transaction transaction = null;*/
	    
	    StrudentCRUDOperation studentDao = new StrudentCRUDOperation();
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        Student student1 = new Student("Tom", "Cruise", "tom@javaguides.com");
        Student student2 = new Student("Tony", "stark", "tony@javaguides.com");
        
        studentDao.saveStudent(student);
        studentDao.saveStudent(student1);
        studentDao.saveStudent(student2);
        studentDao.saveOrUpdateStudent(student2);//deprecated in 6

        studentDao.getStudent(1);
        studentDao.loadStudent(2);//deprecated in 6
        studentDao.getStudentById(3);
        studentDao.saveStudent(student);//deprecated in 6

        List < Student > students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getFirstName()));
	    
        studentDao.persistStudent(student);
        
        // delete student
        studentDao.deleteStudent(1);

        // delete second student
        studentDao.removeStudent(2);
        
        
        
	   /* 
	    //removed to StrudentCRUDOperation
	     try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        // start a transaction
	        transaction = session.beginTransaction();
	        // save the student objects
	        session.persist(student);
	        session.persist(student1);
	        // commit transaction
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }

	    
	    try (Session session2 = HibernateUtil.getSessionFactory().openSession()) {
	        List < Student > students = session2.createQuery("from Student", Student.class).list();
	        students.forEach(s-> System.out.println(s.getFirstName()));
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        ex.printStackTrace();
	    }*/
	}
}
