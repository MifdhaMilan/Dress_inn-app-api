package com.dress.app.service;

import java.util.UUID;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dress.app.exception.DressNotFoundException;
import com.dress.app.model.Dress;
import com.dress.app.repository.DressRepo;


@Service
public class DressService {
	private final DressRepo dressRepo;

	@Autowired
	public DressService(DressRepo dressRepo) {
		 this.dressRepo = dressRepo;
	}
	public Dress addDress(Dress dress) {
		dress.setDressCode(UUID.randomUUID().toString());
		return dressRepo.save(dress);
	}
	public List<Dress> findAllDresses(){
		return dressRepo.findAll();
	}
	public Dress findDressById(Long id) {
		return dressRepo.findDressById(id).orElseThrow(() -> new DressNotFoundException("Dress by id "+id+" was not found"));
	}
	public Dress updateDress(Dress dress) {
		return dressRepo.save(dress);
	}
	public void deleteDress(Long id) {
		dressRepo.deleteDressById(id);
	}
	
	
   
}
