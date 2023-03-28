package kodlama.io.languageDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.languageDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.languageDevs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.responses.GetAllProgrammingLanguageResponses;

@RestController
@RequestMapping("/api/language")
public class ProgrammingLanguageController {

	ProgrammingLanguageService programmingLanguageService;
	
	
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}



	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		
		programmingLanguageService.add(createProgrammingLanguageRequest);
		
		
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageResponses> getAll(){
		
		return programmingLanguageService.getAll();
		
	}
	
	@DeleteMapping("/remove")
	public void remove(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest) {
		
		programmingLanguageService.remove(removeProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		programmingLanguageService.update(updateProgrammingLanguageRequest);
		
	}
	
}
