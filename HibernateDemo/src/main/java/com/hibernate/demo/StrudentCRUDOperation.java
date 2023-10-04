package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.demo.entity.Student;
import com.hibernate.demo.entity.config.HibernateUtil;
import com.hibernate.demo.entity.config.HibernateUtil_2;

//https://www.javaguides.net/p/hibernate-tutorial.html
public class StrudentCRUDOperation {

	public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil_2.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            //https://www.digitalocean.com/community/tutorials/hibernate-session-merge-vs-update-save-saveorupdate-persist-example
            long id1 = (Long) session.save(student);
            // commit transaction
            transaction.commit();
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < Student > getStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }
        
       /* try (Session session2 = HibernateUtil.getSessionFactory().openSession()) {
	        List < Student > students = session2.createQuery("from Student", Student.class).list();
	        students.forEach(s-> System.out.println(s.getFirstName()));
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        ex.printStackTrace();
	    }*/
        
        
        public void persistStudent(Student student) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();
                // save the student object
                session.persist(student);
                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        
        public  void saveOrUpdateStudent(Student student) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();
                // save the student object
                session.saveOrUpdate(student);

                // get entity from database
                Student student2 = session.get(Student.class, 1);

                // do changes 
                student2.setFirstName("Ram");

                // update the student object
                session.saveOrUpdate(student2);

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
            
        public void getStudent(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // get Student entity using get() method
                Student student = session.get(Student.class, id);
                System.out.println(student.getFirstName());
                System.out.println(student.getEmail());

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void loadStudent(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // get Student entity using load() method
                Student student = session.load(Student.class, id);
                System.out.println(student.getFirstName());
                System.out.println(student.getEmail());

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void getStudentById(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // Obtain an entity using byId() method
                Student student = session.byId(Student.class).getReference(id);
                System.out.println(student.getFirstName());
                System.out.println(student.getEmail());

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void merge(Student stu) {
        	Transaction transactionOne = null;
            Transaction transactionTwo = null;
            
            try (Session sessionOne  = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
            	transactionOne  = sessionOne.beginTransaction();

            	// create student object
                Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");

                // save student object
                sessionOne.persist(student);

                // commit transaction
                transactionOne.commit();

                // close first session 
                sessionOne.close();

                // open sessionTwo
                Session sessionTwo = HibernateUtil.getSessionFactory().openSession();

                transactionTwo = sessionTwo.beginTransaction();

                // change detached student object name
                student.setFirstName("Ram");

                // merge method is to update a persistent entity instance with new field values
                // from a detached entity instance.
                sessionTwo.merge(student);

                transactionTwo.commit();

                sessionTwo.close();
                
            } catch (Exception e) {
                if (transactionOne != null) {
                	transactionOne.rollback();
                }
                e.printStackTrace();
            }
        }
      
        public void deleteStudent(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // Delete a persistent object
                Student student = session.get(Student.class, id);
                if (student != null) {
                    session.delete(student);
                    System.out.println("student 1 is deleted");
                }

                // Delete a transient object
                Student student2 = new Student();
                student2.setId(2);
                session.delete(student2);
                System.out.println("Student 2 is deleted");

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        
        public void removeStudent(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // Delete a persistent object
                Student student = session.get(Student.class, id);
                if (student != null) {
                    session.remove(student);
                    System.out.println("student 1 is deleted");
                }

                // Delete a transient object
                Student student2 = new Student();
                student2.setId(2);
                session.remove(student2);
                System.out.println("Student 2 is deleted");

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        
        /**
         In this short article, we will learn how to remove cache objects from the first-level cache using the Session.evict() method with an example.
		 The Session.evict() is used to remove a particular object from the cache associated with the session.
		 
         https://www.javaguides.net/2019/12/hibernate-sessionevict-method-example.html
         
         Clearly, a clear() method removed all the student objects from the first-level cache so that it was fetched again from the database.
         */
       // session.evict(student2);
        
        
        //Hibernate Query Language INSERT, UPDATE, SELECT and DELETE Example
        //https://www.javaguides.net/2018/12/hibernate-transaction-management-tutorial.html
        /*
        public void insertStudent() {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                String hql = "INSERT INTO Student (firstName, lastName, email) " +
                    "SELECT firstName, lastName, email FROM Student";
                Query query = session.createQuery(hql);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void updateStudent(Student student) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // save the student object
                String hql = "UPDATE Student set firstName = :firstName " + "WHERE id = :studentId";
                Query query = session.createQuery(hql);
                query.setParameter("firstName", student.getFirstName());
                query.setParameter("studentId", 1);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void deleteStudent(int id) {

            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // Delete a student object
                Student student = session.get(Student.class, id);
                if (student != null) {
                    String hql = "DELETE FROM Student " + "WHERE id = :studentId";
                    Query query = session.createQuery(hql);
                    query.setParameter("studentId", id);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public Student getStudent(int id) {

            Transaction transaction = null;
            Student student = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // get an student object
                String hql = " FROM Student S WHERE S.id = :studentId";
                Query query = session.createQuery(hql);
                query.setParameter("studentId", id);
                List results = query.getResultList();

                if (results != null && !results.isEmpty()) {
                    student = (Student) results.get(0);
                }
                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return student;
        }

        public List < Student > getStudents() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from Student", Student.class).list();
            }
        }*/
    }

