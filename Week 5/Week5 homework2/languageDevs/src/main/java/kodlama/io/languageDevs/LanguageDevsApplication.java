package kodlama.io.languageDevs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LanguageDevsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanguageDevsApplication.class, args);
	}

	 @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        
	        return modelMapper;
	    }
	
}
