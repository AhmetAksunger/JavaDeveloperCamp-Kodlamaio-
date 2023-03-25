package kodlamaio.dataAccess;

import kodlamaio.entities.Course;

public class HibernateCourseDao implements CourseDao {

	@Override
	public void add(Course course) {
		
		//commands to add course into database using hibernate
		System.out.println("Course has been added using hibernate: " + "NAME: " + course.getName() + "ID: " + course.getId());
		
	}

	@Override
	public void update(Course course) {
		
		//commands to update course from database using hibernate
		System.out.println("Course has been updated using hibernate: " + "NAME: " + course.getName() + "ID: " + course.getId());
		
	}

	@Override
	public void remove(Course course) {
		
		//commands to remove course from database using hibernate
		
		System.out.println("Course has been removed using hibernate: " + "NAME: " + course.getName() + "ID: " + course.getId());
		
	}

}
