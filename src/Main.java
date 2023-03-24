import kodlamaio.business.CategoryManager;
import kodlamaio.business.CourseManager;
import kodlamaio.business.InstructorManager;
import kodlamaio.core.logging.DatabaseLogger;
import kodlamaio.core.logging.FileLogger;
import kodlamaio.core.logging.Logger;
import kodlamaio.core.logging.MailLogger;
import kodlamaio.dataAccess.HibernateCourseDao;
import kodlamaio.dataAccess.JdbcCategoryDao;
import kodlamaio.dataAccess.JdbcInstructorDao;
import kodlamaio.entities.Category;
import kodlamaio.entities.Course;
import kodlamaio.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//Entities
		
		Instructor instructor1 = new Instructor("Ahmet","Aksunger",19,"ahmet.aksunger@bilgiedu.net",1);
		Instructor instructor2 = new Instructor("Engin","Demirog",35,"engin_demirog@kodlamaio.net",2);
		Instructor instructor3 = new Instructor("Ayşe","Yildiz",23,"aye_yildiz@bilmemne.net",3);
		Instructor instructor4 = new Instructor("Mustafa","Mistik",21,"mustafamistik@uniuniedu.net",4);
		
		Instructor[] instructors = {instructor1,instructor2,instructor3,instructor4};
		
		Category category1 = new Category(1,"Programming");
		Category category2 = new Category(2,"Machine Learning");
		
		Category[] categories = {category1,category2};
		
		Course course1 = new Course(1,"Java Camp","Java Camp in 6 months",instructor2,300,category1);
		Course course2 = new Course(2,"Machine Learning Camp","Understand machine learning asap",instructor1,500,category2);
		Course course3 = new Course(3,"Python Selenium Camp","Python Selenium Camp for Test Engineers",instructor3,300,category1);
		Course course4 = new Course(4,"JavaScript Camp","JavaScript Camp in 6 months",instructor4,200,category1);
		
		Course[] courses = {course1,course2,course3,course4};
		
		//Business
		
		InstructorManager instructorManager = new InstructorManager(new MailLogger(),instructors,new JdbcInstructorDao());
		
		instructorManager.Add(new Instructor("Mustafa","Yilmaz",22,"sdjkfhsjkdf@gmail.com",5));
		
		CourseManager courseManager = new CourseManager(courses,new HibernateCourseDao(),new DatabaseLogger());
		
		courseManager.Add(new Course(5,"Html Css","Learn html css in 6 hours",instructor2,100,category1));
		
		CategoryManager categoryManager = new CategoryManager(categories,new JdbcCategoryDao(),new FileLogger());
		
		categoryManager.Add(new Category(3,"Algorithm"));
		
	}
	

}
