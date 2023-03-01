package com.example.DSS_project.controller;

import com.example.DSS_project.Repository.SkierRepository;
import com.example.DSS_project.model.SeasonRequest;
import com.example.DSS_project.model.Skier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController	
@CrossOrigin
@RequestMapping(value = "/api")
public class SkierController {

	@Autowired
    SkierRepository skierRepository;
    
   

    @GetMapping("/resorts")
    public ResponseEntity<List<Skier>> getResorts() {
        return ResponseEntity.ok(this.skierRepository.findAll());
    }

    @PostMapping("/resorts/{resortID}/seasons")
    public ResponseEntity<Skier> createSeason(@PathVariable String resortID, @RequestBody SeasonRequest seasons) {
    	Skier skier = skierRepository.findByResortID(resortID);
    	System.out.println(skier.getSeasonID() + "hurrya");
	    skier.setSeasonID(seasons.getYear());
	    System.out.println(skier.getSeasonID() + "Aafter the change");
	    return ResponseEntity.status(201).body(this.skierRepository.save(skier));
    }

    //@GetMapping("/product/{id}")
    //public ResponseEntity getProductById(@PathVariable String id) {
    // Optional<Product> product = this.productRepository.findById(id);
    //if(product.isPresent()) {
    //return ResponseEntity.ok(product.get());
    //} else {
    //return ResponseEntity.ok("The product with id: " + id + " was not found.");
    //}
    
    /**
     * @param resortID
     * @param seasonID
     * @param dayID
     * @param skierID
     * @return
     */
    @PostMapping("/skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}")
    public ResponseEntity<Skier> createRandomLiftEvent(@PathVariable String resortID,@PathVariable String seasonID,@PathVariable String dayID,@PathVariable String skierID){
    	Skier skier = new Skier();
    	skier.setResortID(resortID);
    	skier.setSeasonID(seasonID);
    	skier.setDayID(dayID);
    	skier.setSkierID(skierID);
    	skier.setLiftID(String.valueOf((1 + (int)Math.random() * ((40 - 1) + 1))));
    	skier.setTime("25");
    	
    	
    	
    }
}
