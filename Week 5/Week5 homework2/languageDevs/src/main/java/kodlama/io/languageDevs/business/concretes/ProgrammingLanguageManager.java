package kodlama.io.languageDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.languageDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.languageDevs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.responses.GetAllProgrammingLanguageResponses;
import kodlama.io.languageDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.languageDevs.entities.concretes.ProgrammingLanguage;
@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}



	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
		
	}



	@Override
	public List<GetAllProgrammingLanguageResponses> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages =  programmingLanguageRepository.findAll();
		
		List<GetAllProgrammingLanguageResponses> responses = new ArrayList<GetAllProgrammingLanguageResponses>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			
			var responseItem = new GetAllProgrammingLanguageResponses();
			
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			responses.add(responseItem);
			
		}
		return responses;
		
	}



	@Override
	public void remove(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest) {
		
		programmingLanguageRepository.deleteById(removeProgrammingLanguageRequest.getId());
		
	}



	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		Optional<ProgrammingLanguage> languageOptional = programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId());
		
		if(languageOptional.isPresent()) {
			
			var programmingLanguage = languageOptional.get();
			
			programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
			programmingLanguage.setName(updateProgrammingLanguageRequest.getNewName());
			
			programmingLanguageRepository.save(programmingLanguage);
			
		}else {
			
			throw new Exception("No language with the given id");
			
		}
		
	}

}
