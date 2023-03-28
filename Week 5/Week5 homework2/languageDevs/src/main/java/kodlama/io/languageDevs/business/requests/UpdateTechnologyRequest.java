package kodlama.io.languageDevs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {

	private int id;
	private String newName;
	private int newProgrammingLanguageId;
	
	
}
