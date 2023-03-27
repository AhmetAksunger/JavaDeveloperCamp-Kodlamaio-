package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	

	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}
	

	@Override
	public void add(Language language) throws Exception {
		
		if (language.getName().isEmpty()) {
			throw new Exception("Name cannot be null");
		}
		languageRepository.add(language);
		
	}

	@Override
	public void remove(Language language) {
		
		languageRepository.remove(language);
		
	}

	@Override
	public void update(Language oldLanguage, Language newLanguage) throws Exception {
		
		if(oldLanguage.getName().isEmpty()) {
			throw new Exception("Name cannot be null");
		}
		
		
	}


	@Override
	public Language getById(int id) throws Exception {
		
		return languageRepository.getById(id);
		
	}


	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}

	
	
	
	
	

}
