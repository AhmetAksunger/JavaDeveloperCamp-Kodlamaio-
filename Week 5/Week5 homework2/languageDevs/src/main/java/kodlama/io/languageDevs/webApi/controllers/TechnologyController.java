package kodlama.io.languageDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.languageDevs.business.abstracts.TechnologyService;
import kodlama.io.languageDevs.business.requests.CreateTechnologyRequest;
import kodlama.io.languageDevs.business.requests.RemoveTechnologyRequest;
import kodlama.io.languageDevs.business.requests.UpdateTechnologyRequest;
import kodlama.io.languageDevs.business.responses.GetAllTechnologyResponses;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

	private TechnologyService technologyService;
	
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}


	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		
		technologyService.add(createTechnologyRequest);
		
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponses> getAll(){
		
		return technologyService.getAll();
		
	}
	
	@DeleteMapping("/remove")
	public void remove(RemoveTechnologyRequest removeTechnologyRequest) {
		
		
		technologyService.remove(removeTechnologyRequest);
		
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		
		technologyService.update(updateTechnologyRequest);
		
	}
	
}
