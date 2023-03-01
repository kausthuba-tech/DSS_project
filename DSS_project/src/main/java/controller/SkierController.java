package controller;

import com.example.DSS_project.Repository.SkierRepository;
import com.example.DSS_project.model.Skier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkierController {

    private final SkierRepository skierRepository;


    public SkierController(SkierRepository skierRepository) {
        this.skierRepository = skierRepository;
    }

    //public SkierController(SkierRepository skierRepository) {
    //  this.skierRepository = skierRepository;
    //}

    @GetMapping("/resorts")
    public ResponseEntity<List<Skier>> getResorts() {
        return ResponseEntity.ok(this.skierRepository.findAll());
    }

    //@PostMapping("/resorts/{resortID}/seasons")
    //public ResponseEntity<Skier> createSeason(@PathVariable String resortID, @RequestBody SeasonRrequest seasons) {
    //skier.setSeasonID(skier.getSeasonID());
    //return ResponseEntity.status(201).body(this.skierRepository.save(skier));Request}

    //@GetMapping("/product/{id}")
    //public ResponseEntity getProductById(@PathVariable String id) {
    // Optional<Product> product = this.productRepository.findById(id);
    //if(product.isPresent()) {
    //return ResponseEntity.ok(product.get());
    //} else {
    //return ResponseEntity.ok("The product with id: " + id + " was not found.");
    //}
}
