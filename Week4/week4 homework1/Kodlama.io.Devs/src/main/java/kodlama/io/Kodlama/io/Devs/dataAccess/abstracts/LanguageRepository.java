package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.Language;

public interface LanguageRepository {
	
	public void add(Language language) throws Exception;
	
	public void remove(Language language);
	
	public void update(Language oldLanguage, Language newLanguage) throws Exception;
	
	public Language getById(int id) throws Exception;
	
	public List<Language> getAll();
	

}
