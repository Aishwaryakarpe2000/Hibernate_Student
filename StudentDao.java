package hibernate_student.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_student.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("aishwarya");
//		EntityManager em=emf.createEntityManager();	//first method always return an Object inthat time only we use method chaining
//		return em;

		return Persistence.createEntityManagerFactory("aishwarya").createEntityManager();
	}

	public void saveStudent(Student s) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(s);
		et.commit();

		System.out.println("Saved Successfull");
	}

	public void update(int id,Student s) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student dbstd = em.find(Student.class, id);
		if (dbstd != null) {
			
			s.setId(id);
			et.begin();
			em.merge(s); // for update we use merge entity object ....merge()is polymorphic in nature
			et.commit();
			System.out.println("Updated Successfully...!");
			
		} else {
			System.out.println("Student With Given Id "+id+ " Not Found");
		}
	}

	public void updateByPhone(int id, long phone) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = em.find(Student.class, id);
		if (s != null) {
			s.setPhone(phone);
			et.begin();
			em.merge(s);
			et.commit();
			System.out.println("Updated Successfully...!");

		} else {
			System.out.println("Student With Given Id "+id+ " Not Found");
		}
	}
	
	
	public void updateByName(int id, String name) {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = em.find(Student.class, id);
		if (s != null) {
			s.setName(name);
			et.begin();
			em.merge(s);
			et.commit();
			System.out.println("Updated Successfully...!");

		} else {
			System.out.println("Student With Given Id "+id+ " Not Found");
		}
	}
	
	
	public void updateByMarks(int id, int marks) {
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = em.find(Student.class, id);
		if (s != null) {
			s.setMarks(marks);
			et.begin();
			em.merge(s);
			et.commit();
			System.out.println("Updated Successfully...!");

		} else {
			System.out.println("Student With Given Id "+id+ " Not Found");
		}
	}
	
	
	public void updateByAddress(int id, String address) {
		
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = em.find(Student.class, id);
		if (s != null) {
			s.setAddress(address);
			et.begin();
			em.merge(s);
			et.commit();
			System.out.println("Updated Successfully...!");

		} else {
			System.out.println("Student With Given Id "+id+ " Not Found");
		}
	}

	

	public void findById(int id) {

		EntityManager em = getEntityManager();
		Student s = em.find(Student.class, id); // dql query which is Autocommit

		if (s != null) {
			System.out.println(s);
		} else {
			System.out.println("Student with the Given Id " + id + " not Found");
		}
	}

	public void findAll() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("SELECT s FROM Student s");
		List<Student> list = q.getResultList();

		System.out.println(list);
	}

	public void findByPhone(long phone) {

		EntityManager em = getEntityManager();

		Query q = em.createQuery("SELECT s FROM Student s WHERE 	s.phone=?1");
		q.setParameter(1, phone);

		try {
			Student s = (Student) q.getSingleResult();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("Student with the Given phone " + phone + " not Found");
		}
	}

	public void delete(int id) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student dbstd = em.find(Student.class,id);
		if (dbstd != null) {
			et.begin();
			em.remove(dbstd); 
			et.commit();
			
			System.out.println("Deleted Successfull");
			
		} else {
			System.out.println("Student with the Given phone " + id + " not Found");
		}
	}
	
	public void deleteByPhone(long phone) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Query q = em.createQuery("SELECT s from  Student s WHERE s.phone=?1");
		q.setParameter(1, phone);

		try {
			Student s = (Student) q.getSingleResult();
			//System.out.println(s);
			et.begin();
			em.remove(s); 
			et.commit();
			
			System.out.println("Deleted Successfull");
			
		} catch (Exception e) {
			System.out.println("Student with the Given phone " + phone + " not Found");
		}
	}
	
	public void deleteByAddress(String address) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Query q = em.createQuery("SELECT s from  Student s WHERE  s.address=?1");
		q.setParameter(1, address);

		List<Student> l= q.getResultList();
		
		for(Student s:l)
		{
			et.begin();
			em.remove(s); 
			et.commit();
		}
			
	}

}
