package com.dress.app.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dress.app.model.Dress;
import com.dress.app.service.DressService;

@RestController
@RequestMapping("/dress")
public class DressController {
	private final DressService dressService;

	
	public DressController(DressService dressService) {
		this.dressService = dressService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Dress>> getAllDresses(){
		List<Dress> dresses = dressService.findAllDresses();
		return new ResponseEntity<>(dresses, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Dress> getDressById(@PathVariable("id") long id){
		Dress dress = dressService.findDressById(id);
		return new ResponseEntity<>(dress, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Dress> addDress(@RequestBody Dress dress){
		Dress newDress = dressService.addDress(dress);
		return new ResponseEntity<>(newDress, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Dress> updateDress(@RequestBody Dress dress){
		Dress updateDress = dressService.updateDress(dress);
		return new ResponseEntity<>(updateDress, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDress(@PathVariable("id") long id){
		dressService.deleteDress(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
