package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entities.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageControllers {

	private LanguageService languageService;

	public LanguageControllers(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	public void add(Language language) throws Exception {
		
		languageService.add(language);
		
	}
	
	@DeleteMapping("/remove")
	public void remove(Language language) {
		
		languageService.remove(language);
		
	}
	
	@PutMapping("/update")
	public void update(Language oldLanguage, Language newLanguage) throws Exception {
		
		languageService.update(oldLanguage, newLanguage);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public Language getById(@PathVariable int id) throws Exception {
		
		return languageService.getById(id);
		
	}
	
	@GetMapping("/all")
	public List<Language>getAll() throws Exception {
		
		return languageService.getAll();
		
	}
	
	
	
}
