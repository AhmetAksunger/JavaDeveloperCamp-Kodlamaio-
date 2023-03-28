package kodlama.io.languageDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.languageDevs.business.abstracts.TechnologyService;
import kodlama.io.languageDevs.business.requests.CreateTechnologyRequest;
import kodlama.io.languageDevs.business.requests.RemoveTechnologyRequest;
import kodlama.io.languageDevs.business.requests.UpdateTechnologyRequest;
import kodlama.io.languageDevs.business.responses.GetAllTechnologyResponses;
import kodlama.io.languageDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.languageDevs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.languageDevs.entities.concretes.ProgrammingLanguage;
import kodlama.io.languageDevs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	TechnologyRepository technologyRepository;
	ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}




	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		
		Technology technology = new Technology();
		
		Optional<ProgrammingLanguage> programmingLangOptional = programmingLanguageRepository.findById(createTechnologyRequest.getProgrammingLanguageId());
		
		if(programmingLangOptional.isPresent()) {
			
			ProgrammingLanguage programmingLanguage = programmingLangOptional.get();
			technology.setName(createTechnologyRequest.getName());
			technology.setProgrammingLanguage(programmingLanguage);
			technologyRepository.save(technology);	
			
		}
		
		
	}




	@Override
	public List<GetAllTechnologyResponses> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		
		List<GetAllTechnologyResponses> responses = new ArrayList<GetAllTechnologyResponses>();
		
		for (Technology technology : technologies) {
			
			var responseItem = new GetAllTechnologyResponses();
			
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			
			var programmingLanguage = technology.getProgrammingLanguage();
			
			responseItem.setProgrammingLanguageId(programmingLanguage.getId());
			
			responses.add(responseItem);
			
			
		}
		
		return responses;
	}




	@Override
	public void remove(RemoveTechnologyRequest removeTechnologyRequest) {
		
		technologyRepository.deleteById(removeTechnologyRequest.getId());
		
	}




	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		
		Optional<Technology> technOptional  = technologyRepository.findById(updateTechnologyRequest.getId());
		
		if(technOptional.isPresent()) {
			
			var technology = technOptional.get();
			
			technology.setId(updateTechnologyRequest.getId());
			technology.setName(updateTechnologyRequest.getNewName());
			
			if(updateTechnologyRequest.getNewProgrammingLanguageId() != 0) {
				Optional<ProgrammingLanguage> progOptional = programmingLanguageRepository.findById(updateTechnologyRequest.getNewProgrammingLanguageId());
				
				technology.setProgrammingLanguage(progOptional.get());
				
			}
			technologyRepository.save(technology);
			
		}
		
	}
	
	
	

}
