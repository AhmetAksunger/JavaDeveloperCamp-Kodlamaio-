package kodlama.io.languageDevs.business.abstracts;

import java.util.List;

import kodlama.io.languageDevs.business.requests.CreateTechnologyRequest;
import kodlama.io.languageDevs.business.requests.RemoveTechnologyRequest;
import kodlama.io.languageDevs.business.requests.UpdateTechnologyRequest;
import kodlama.io.languageDevs.business.responses.GetAllTechnologyResponses;

public interface TechnologyService {

	void add(CreateTechnologyRequest createTechnologyRequest);
	
	List<GetAllTechnologyResponses> getAll();
	
	void remove(RemoveTechnologyRequest removeTechnologyRequest);
	
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	
}
