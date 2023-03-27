package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	//act like this is the database
	private List<Language> languages;
	
	
	@Autowired
	public InMemoryLanguageRepository() {

		
		languages = new ArrayList<>();
		languages.add(new Language(1,"Java"));
		languages.add(new Language(2,"C#"));
		languages.add(new Language(3,"Python"));
		languages.add(new Language(4,"C++"));
		languages.add(new Language(5,"C"));
		languages.add(new Language(6,"JavaScript"));
		
	}

	@Override
	public void add(Language language) throws Exception {
		
		languages.add(language); 	
		
	}

	@Override
	public void remove(Language language){
		
		languages.remove(language);
		
	}

	@Override
	public void update(Language oldLanguage, Language newLanguage) throws Exception{
		
		int index = languages.indexOf(oldLanguage);
		
		languages.set(index, newLanguage);
		
	}

	@Override
	public Language getById(int id) throws Exception {
		
		for (Language language : languages) {
			
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

}
