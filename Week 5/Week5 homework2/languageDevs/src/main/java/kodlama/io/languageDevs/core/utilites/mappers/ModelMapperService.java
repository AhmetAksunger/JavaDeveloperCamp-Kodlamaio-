package kodlama.io.languageDevs.core.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forRequest();
	ModelMapper forResponse();
	
}
