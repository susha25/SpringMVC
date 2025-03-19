package spring.orm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean end = true;

		while (end) {
			try {

				System.out.println(" Enter Operation You Want\n" + "1.Insert Student\n" + "2.Update Student\n"
						+ "3.Delete Student\n" + "4.Read Student\n" + "5.Exit\n");
				
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					System.out.println("*****Inserting Start***********");
					System.out.println("Enter Student Id");
					int i = Integer.parseInt(br.readLine());

					System.out.println("Enter Student Name");
					String name = br.readLine();

					System.out.println("Enter Student City");
					String city = br.readLine();

					System.out.println("Enter Student Style");
					String Style = br.readLine();

					Student std = new Student();
					std.setStudentId(i);
					std.setStudentName(name);
					std.setStudentCity(city);
					std.setStudent_style(Style);

					int r = studentDao.insert(std);
					System.out.println("Inserted Id: " + r);

					break;

				case 2:
					System.out.println("*****Update Start***********");
					ArrayList<Student> studentList = (ArrayList<Student>) studentDao.getAllStudent();
					for (Student stds : studentList) {
						System.out.println(stds);
					}
					System.out.println("*********************************************");

					System.out.println("Enter Student Id");
					int id = Integer.parseInt(br.readLine());

					Student stdunt = studentDao.getStudent(id);

					System.out.println("*********************************");
					System.out.println("Enter Student Name ");
					stdunt.setStudentName(br.readLine());
					System.out.println("Enter Student City ");
					stdunt.setStudentCity(br.readLine());
					System.out.println("Enter Student Style ");
					stdunt.setStudent_style(br.readLine());

					studentDao.update(stdunt);

					break;

				case 3:
					System.out.println("Deleting Student Data");
					System.out.println("Enter Student ID For Deleting");
					int deleteId = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(deleteId);
					
					break;

				case 4:
					System.out.println("*****Get All Student Start***********");
					ArrayList<Student> studentLists = (ArrayList<Student>) studentDao.getAllStudent();
					for (Student stds : studentLists) {
						System.out.println(stds);
					}
					System.out.println("*********************************************");
					break;

				case 5:
                      end=false;
					break;
				case 6:

					break;
				case 7:

					break;

				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Exiting From Program");
		}

		/*
		 * 
		 * Student stud1 = new Student(10,"Sachin Tendulkar","Mumbai","Batsman");
		 * 
		 * int r = studentDao.insert(stud1);
		 * 
		 * System.out.println("DONE for "+r);
		 * 
		 * 
		 * 
		 * int arr[] = {18,25,45};
		 * 
		 * for(int i=0;i<arr.length;i++) { Student std = studentDao.getStudent(arr[i]);
		 * std.setStudent_style("Batsman"); studentDao.update(std); }
		 * 
		 * studentDao.update(student);
		 * 
		 * studentDao.deleteStudent(18);
		 * 
		 * ArrayList<Student> std = new ArrayList<Student>();
		 * 
		 * std = (ArrayList<Student>) studentDao.getAllStudent();
		 * 
		 * for(Student i:std) { System.out.println(i); }
		 * 
		 * System.out.
		 * println("************************************** Done ************************* "
		 * );
		 */

	}

}
