package kodlama.io.languageDevs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.languageDevs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.languageDevs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.responses.GetAllProgrammingLanguageResponses;
import kodlama.io.languageDevs.core.utilites.mappers.ModelMapperService;
import kodlama.io.languageDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.languageDevs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		
		//ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		
		//programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
		ProgrammingLanguage programmingLanguage = modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		
		programmingLanguageRepository.save(programmingLanguage);
		
	}



	@Override
	public List<GetAllProgrammingLanguageResponses> getAll() {
		
//		List<ProgrammingLanguage> programmingLanguages =  programmingLanguageRepository.findAll();
//		
//		List<GetAllProgrammingLanguageResponses> responses = new ArrayList<GetAllProgrammingLanguageResponses>();
//		
//		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
//			
//			var responseItem = new GetAllProgrammingLanguageResponses();
//			
//			responseItem.setId(programmingLanguage.getId());
//			responseItem.setName(programmingLanguage.getName());
//			
//			responses.add(responseItem);
//			
//		}
		
		List<ProgrammingLanguage> programmingLanguages =  programmingLanguageRepository.findAll();
		
		List<GetAllProgrammingLanguageResponses> responses = programmingLanguages.stream().map(language-> modelMapperService.forResponse().map(language, GetAllProgrammingLanguageResponses.class)).collect(Collectors.toList());
		
		return responses;
		
	}



	@Override
	public void remove(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest) {
		
		programmingLanguageRepository.deleteById(removeProgrammingLanguageRequest.getId());

		
	}



	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
//		Optional<ProgrammingLanguage> languageOptional = programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId());
//		
//		if(languageOptional.isPresent()) {
//			
//			var programmingLanguage = languageOptional.get();
//			
//			programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
//			programmingLanguage.setName(updateProgrammingLanguageRequest.getNewName());
//			
//			programmingLanguageRepository.save(programmingLanguage);
//			
//		}else {
//			
//			throw new Exception("No language with the given id");
//			
//		}
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId()).orElseThrow();
		
		programmingLanguage = modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		
		programmingLanguageRepository.save(programmingLanguage);
		
		
	}

}
