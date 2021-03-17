package com.dress.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.dress.app.model.Dress;


public interface DressRepo extends JpaRepository<Dress, Long> {

	 //query method
	void deleteDressById(Long id);

	Optional<Dress> findDressById(Long id);
}
