package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer>{

	//jpa exist ve name bir arada kullanıldığı için
	//bizim için o isimde bir obje var mı yok mu kontrol eder
	
	boolean existsByName(String name); //spring jpa keywords
	
	
	
}
