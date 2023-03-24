package kodlamaio.dataAccess;

import kodlamaio.entities.Category;

public class HibernateCategoryDao implements CategoryDao{

	@Override
	public void add(Category category) {
		
		System.out.println("Category has been added using hibernate: " + "NAME: " + category.getName() + "ID: " + category.getId());
		
	}

	@Override
	public void remove(Category category) {
		
		System.out.println("Category has been removed using hibernate: " + "NAME: " + category.getName() + "ID: " + category.getId());
		
	}

	@Override
	public void update(Category category) {
		
		System.out.println("Category has been updated using hibernate: " + "NAME: " + category.getName() + "ID: " + category.getId());
		
	}

}
