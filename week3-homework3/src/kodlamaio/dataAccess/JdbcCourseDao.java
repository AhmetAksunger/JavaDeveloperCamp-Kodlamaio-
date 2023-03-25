package kodlamaio.dataAccess;

import kodlamaio.entities.Course;

public class JdbcCourseDao implements CourseDao {

	@Override
	public void add(Course course) {
		
		//commands to add a course into database using jdbc
		System.out.print("Course has been added using jdbc: " + "NAME: " + course.getName() + "ID: " + course.getId());
	}

	@Override
	public void update(Course course) {
		
		//commands to update a course from database using jdbc
		System.out.print("Course has been updated using jdbc: " + "NAME: " + course.getName() + "ID: " + course.getId());
		
	}

	@Override
	public void remove(Course course) {
		
		//commands to remove a course from database using jdbc
		System.out.print("Course has been removed using jdbc: " + "NAME: " + course.getName() + "ID: " + course.getId());
		
	}

}
