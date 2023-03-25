package kodlamaio.dataAccess;

import kodlamaio.entities.Instructor;

public class HibernateInstructorDao implements InstructorDao{
	
	@Override
	public void add(Instructor instructor) {
		
		System.out.println("Instructor has been added using hibernate: " + "NAME: " + instructor.getFirstName() + instructor.getLastName() + "ID: " + instructor.getId());
		
	}

	@Override
	public void update(Instructor instructor) {
		
		System.out.println("Instructor has been updated using hibernate: " + "NAME: " + instructor.getFirstName() + instructor.getLastName() + "ID: " + instructor.getId());
		
	}

	@Override
	public void remove(Instructor instructor) {
		
		System.out.println("Instructor has been removed using hibernate: " + "NAME: " + instructor.getFirstName() + instructor.getLastName() + "ID: " + instructor.getId());
		
	}

}
