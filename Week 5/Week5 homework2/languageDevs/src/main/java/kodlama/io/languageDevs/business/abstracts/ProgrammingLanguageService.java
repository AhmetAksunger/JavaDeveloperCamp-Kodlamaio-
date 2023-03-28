package kodlama.io.languageDevs.business.abstracts;

import java.util.List;


import kodlama.io.languageDevs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.RemoveProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.languageDevs.business.responses.GetAllProgrammingLanguageResponses;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	
	List<GetAllProgrammingLanguageResponses> getAll();
	
	void remove(RemoveProgrammingLanguageRequest removeProgrammingLanguageRequest);
	
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
}
