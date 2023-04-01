package kodlama.io.rentACar.core.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forResponse();
	
	ModelMapper forRequest();
	
	
}
