package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.paie.entite.Avantage;

//@Component

public interface AvantageRepository extends JpaRepository<Avantage, Integer> {

	List<Avantage> findByCodeAndNom(String code, String nom);

}
