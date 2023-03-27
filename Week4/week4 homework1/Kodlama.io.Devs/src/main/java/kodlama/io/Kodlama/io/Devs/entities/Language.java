package kodlama.io.Kodlama.io.Devs.entities;

public class Language {

	private int id;
	private String name;
	
	public Language(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		
		this.id = id;
	}

	public int getId() {
		
		return id;
		
	}
	
	public void setName(String name) {
		
		this.name = name; 
	}
	
	public String getName() {
		
		return name;
		
	}
	
}
