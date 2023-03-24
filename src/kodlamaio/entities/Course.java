package kodlamaio.entities;

public class Course {

	private int id;
	private String name;
	private String description;
	private Instructor instructor;
	private double price;
	private Category category;
	
	public Course(int id, String name, String description, Instructor instructor, double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.instructor = instructor;
		this.price = price;
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Instructor getCreator() {
		return instructor;
	}
	public void setCreator(Instructor instructor) {
		this.instructor = instructor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
