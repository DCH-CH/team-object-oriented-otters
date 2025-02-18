package com.plateit.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.plateit.project.models.Image;
import com.plateit.project.servicess.ImageService;
import com.plateit.project.models.Beverage;
import com.plateit.project.models.BeverageRepository;

@RestController
@RequestMapping("api")
public class BeverageController {

	@Autowired
	BeverageRepository beverageRepository;
	@Autowired
	ImageService imageService;
	
	@PostMapping("/beverage")
	public ResponseEntity<?> createBeverage(@RequestBody Beverage beverage){
		
		Beverage newBeverage = beverageRepository.save(beverage);
		
		if (newBeverage != null)
			return new ResponseEntity<Beverage>(newBeverage, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/beverage/{id}")
	public ResponseEntity<?> getRestaurant(@PathVariable String id){
		Beverage beverage = beverageRepository.findById(id).orElse(null);
		
		if (beverage != null) {
			return new ResponseEntity<>(beverage, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/beverage")
	public ResponseEntity<List<?>> getAllRestaurants(){
		List <Beverage> beverages = beverageRepository.findAll();
		
		if (!beverages.isEmpty()) {
			return new ResponseEntity<>(beverages, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/beverage")
	public ResponseEntity<?> updateBeverage(@RequestBody Beverage beverage){

		Beverage beverageToUpdate = beverageRepository.findById(beverage.getId()).orElse(null);

		if (beverageToUpdate != null) {
			beverageToUpdate = beverage;
			beverageRepository.save(beverageToUpdate);
			return new ResponseEntity<>(beverageToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/beverage/{id}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable String id){
		Beverage beverage = beverageRepository.findById(id).orElse(null);
		
		if (beverage != null) {
			beverageRepository.delete(beverage);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/beverage-picture")
	public ResponseEntity<?> uploadRestaturantPicture(@RequestPart("file") MultipartFile file){
		MultipartFile uploadedFile = file;
		Image uploadedImage = imageService.uploadFileService(uploadedFile);

		if (uploadedImage != null)
			return new ResponseEntity<Image>(uploadedImage,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
}
