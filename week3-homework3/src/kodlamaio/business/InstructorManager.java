package kodlamaio.business;

import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.InstructorDao;
import kodlamaio.entities.Instructor;

public class InstructorManager {

	Logger logger;
	Instructor[] instructors;
	InstructorDao instructorDao;
	
	public InstructorManager(Logger logger,Instructor[] instructors,InstructorDao instructorDao) {
		this.logger = logger;
		this.instructors = instructors;
		this.instructorDao = instructorDao;
	}
	
	public void Add(Instructor instructor) throws Exception {
		
		for (Instructor i : instructors) {
			
			if(i.getFirstName() == instructor.getFirstName() && i.getLastName() == instructor.getLastName()) {
				throw new Exception("There already is an instructor named: " + instructor.getFirstName() + " " + instructor.getLastName());
			}
			
		}
		//valid
		instructorDao.add(instructor);
		logger.log("NAME: " + instructor.getFirstName() + " " + instructor.getLastName() + " ID: " + instructor.getId());
		
		
	}
	
	public void Update(Instructor instructor) throws Exception {
		
			//valid
			instructorDao.update(instructor);
			logger.log("NAME: " + instructor.getFirstName() + " " + instructor.getLastName() + " ID: " + instructor.getId());
			
		}
		
	
	public void Remove(Instructor instructor) throws Exception {
		
			//valid
			instructorDao.remove(instructor);
			logger.log("NAME: " + instructor.getFirstName() + " " + instructor.getLastName() + " ID: " + instructor.getId());
			
		}
		
	
	
}
