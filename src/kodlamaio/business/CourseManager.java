package kodlamaio.business;

import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.CourseDao;
import kodlamaio.entities.Course;

public class CourseManager {
	
	Logger logger;
	Course[] courses;
	CourseDao courseDao;
	
	
	
	public CourseManager(Course[] courses,CourseDao courseDao,Logger logger) {
		this.courses = courses;
		this.courseDao = courseDao;
		this.logger = logger;
	}


	public void Add(Course course) throws Exception {
		
		for (Course c : courses) {
			
			if(c.getName() == course.getName()) {
				
				throw new Exception("There already is a course named " + course.getName());
			}
			
		}
		if(course.getPrice() <= 0) {
			throw new Exception("Course price cannot be less than or equal to 0");
		}
		
		//valid course
		courseDao.add(course);
		logger.log("NAME: " + course.getName() + " ID: " + course.getId());
		
	}
	
	public void Update(Course course) {
		
		//valid course
		courseDao.update(course);
		logger.log("NAME: " + course.getName() + " ID: " + course.getId());
		
	}
	
	public void Remove(Course course) {
			
			//valid course
			courseDao.remove(course);
			logger.log("NAME: " + course.getName() + " ID: " + course.getId());
			
		}
		
	
	

}
