package kodlama.io.languageDevs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTechnologyResponses {

	private int id;
	private String name;
	
	private int programmingLanguageId;
	
	
}
