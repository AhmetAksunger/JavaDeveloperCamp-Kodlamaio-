package kodlama.io.languageDevs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.languageDevs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
