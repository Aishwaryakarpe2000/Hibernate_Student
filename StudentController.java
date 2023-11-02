package hibernate_student.controller;
import hibernate_student.dao.StudentDao;
import java.util.Scanner;

import hibernate_student.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Student s=new Student();
		StudentDao dao=new StudentDao();
		
		System.out.println("Enter the choice: \n1.Save Student \n2.UpdateAll Student \n3.Delete Student \n4.Find Student By Id"
				+ "\n5.FindAll Student \n6.Find Student By Phone \n7.UpdateStudent by Phone \n8.Update By Name \n9.Update By Marks  \n10..Update By Address"
				+ "\n11.deleteStudent By Phone \n12.DeleteStudent by Address");
		int ch=sc.nextInt();
	
		switch(ch)
		{
			case 1:
			{
				System.out.println("Enetr the Id");
				s.setId(sc.nextInt());
				System.out.println("Enetr the Name");
				s.setName(sc.next());
				System.out.println("Enetr the Phone");
				s.setPhone(sc.nextLong());
				System.out.println("Enetr the Address");
				s.setAddress(sc.next());
				System.out.println("Enetr the Marks");
				s.setMarks(sc.nextInt());
				
				dao.saveStudent(s);
				break;
			}
			case 2:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				System.out.println("Enetr the Name");
				s.setName(sc.next());
				System.out.println("Enetr the Phone");
				s.setPhone(sc.nextLong());
				System.out.println("Enetr the Address");
				s.setAddress(sc.next());
				System.out.println("Enetr the Marks");
				s.setMarks(sc.nextInt());
				
				dao.update(id,s);
				break;
			}
			case 3:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				
				dao.delete(id);
				break;
			}
			case 4:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				
				dao.findById(id);
				break;
			}
			case 5:
			{
				dao.findAll();
				break;
			}
			case 6:
			{
				System.out.println("Enetr the Phone");
				long phone=sc.nextLong();
				
				dao.findByPhone(phone);
				break;
			}
			case 7:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				System.out.println("Enetr the Phone");
				long phone=sc.nextLong();
				
				dao.updateByPhone(id, phone);
				break;
			}
			case 8:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				System.out.println("Enetr the Name");
				String name=sc.next();
				
				dao.updateByName(id, name);
				break;
			}
			case 9:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				System.out.println("Enetr the Marks");
				int marks=sc.nextInt();
				
				dao.updateByMarks(id, marks);
				break;
			}
			case 10:
			{
				System.out.println("Enetr the Id");
				int id=sc.nextInt();
				System.out.println("Enetr the Address");
				String address=sc.next();
				
				dao.updateByAddress(id, address);
				break;
			}
			case 11:
			{
				System.out.println("Enetr the Phone");
				long phone=sc.nextLong();
				
				dao.deleteByPhone(phone);
				break;
			}
			case 12:
			{
				System.out.println("Enetr the Address");
				String address=sc.next();
				
				dao.deleteByAddress(address);
				break;
			}
		}
	}
}
