package kodlamaio.business;

import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.CategoryDao;
import kodlamaio.entities.Category;

public class CategoryManager {

	
	Category[] categories;
	CategoryDao categoryDao;
	Logger logger;
	
	
	
	
	public CategoryManager(Category[] categories, CategoryDao categoryDao, Logger logger) {
		this.categories = categories;
		this.categoryDao = categoryDao;
		this.logger = logger;
	}




	public void Add(Category category) throws Exception {
		
		for (Category c : categories) {
			
			if(c.getName() == category.getName()) {
				throw new Exception("There already is a category named " + category.getName());
			}
		}
		
		//valid category
		categoryDao.add(category);
		logger.log("NAME: " + category.getName() + " ID: " + category.getId());
		
	}
	
	
}
