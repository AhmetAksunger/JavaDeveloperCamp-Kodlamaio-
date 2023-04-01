package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilites.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service //bu sınıfr bir business nesnesidir
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	private ModelMapperService modelMapperService;
	
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandResponse> getAll() {
		// is kuralları
		
		List<Brand> brands = brandRepository.findAll();
		
//		List<GetAllBrandResponse> brandsResponse = new ArrayList<GetAllBrandResponse>();
//		
//		for (Brand brand : brands) {
//			GetAllBrandResponse responseItem = new GetAllBrandResponse();
//			
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			
//			brandsResponse.add(responseItem);
//		}
		
													//brandleri dolaşır
		List<GetAllBrandResponse> brandsResponse = brands.stream()
				.map(brand->modelMapperService.forResponse().map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());
																		//brand takma isim
		return brandsResponse;
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		// Brand brand = new Brand();
		// brand.setName(createBrandRequest.getName());
		
		brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		
		brandRepository.save(brand);
		
	}



	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}



	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		
		brandRepository.save(brand);
		
		
		
	}



	@Override
	public void delete(int id) {
		
		brandRepository.deleteById(id);
		
	}

}
