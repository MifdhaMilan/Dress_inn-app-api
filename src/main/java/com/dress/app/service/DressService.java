package com.dress.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dress.app.exception.DressNotFoundException;
import com.dress.app.model.Dress;
import com.dress.app.repository.DressRepo;


@Service
public class DressService {
	@Autowired
	private DressRepo dressRepo;

	public Dress addDress(Dress dress) {
		return dressRepo.save(dress);
	}
	public List<Dress> findAllDresses(){
		return dressRepo.findAll();
	}
	public List<Dress> findMenDresses(){
		return dressRepo.findDressByType("M");
	}
	public List<Dress> findWomenDresses(){
		return dressRepo.findDressByType("W");
	}
	public Dress findDressById(Long id) {
		return dressRepo.findDressById(id).orElseThrow(() -> new DressNotFoundException("Dress by id "+id+" was not found"));
	}
	public Dress updateDress(Dress dress) {
		Dress existingDress = dressRepo.findById(dress.getId()).orElse(null);
		existingDress.setPrice(dress.getPrice());
	    existingDress.setName(dress.getName());
		existingDress.setImageUrl(dress.getImageUrl());
		existingDress.setStatus(dress.getStatus());
		dressRepo.save(existingDress);
		return existingDress;
		
	}

	public void deleteDress(Long id) {
	dressRepo.deleteById(id);
	}
	
	public void orderDress(long[] id) {
		for(int i=0; i< id.length ;i++) {
		Dress existingDress = dressRepo.findById(id[i]).orElse(null);
		existingDress.setStatus("Ordered");
		dressRepo.save(existingDress);
		}
	}
	public List<Dress> findOrderedDresses() {
		return dressRepo.findDressByStatus("Ordered");
	}
	public void acceptOrderDress(long id) {
		Dress existingDress = dressRepo.findById(id).orElse(null);
		existingDress.setStatus("Available");
		dressRepo.save(existingDress);
		
	}
	
	
   
}
