package com.ust.Spring_Reactive.controller;

import com.ust.Spring_Reactive.dto.Tripdto;
import com.ust.Spring_Reactive.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/addtrip")
    public Mono<Tripdto> addTrip(@RequestBody Mono<Tripdto> tripdtomono){
        return tripService.addTrip(tripdtomono);
    }

    @GetMapping("/gettrip/{id}")
    public Mono<Tripdto> getTrip(@PathVariable String id){
        return tripService.getTripById(id);
    }

    @GetMapping("/gettrips")
    public Flux<Tripdto> getTrips(){
        return tripService.getAllTrips();
    }

    @PutMapping("/updatetrip/{id}")
    public Mono<Tripdto> updateTrip(@PathVariable String id, @RequestBody Mono<Tripdto> tripdtomono){
        return tripService.updateTrip(id, tripdtomono);
    }

    @DeleteMapping("/deletetrip/{id}")
    public Mono<Void> deleteTrip(@PathVariable String id){
        return tripService.deleteTrip(id);
    }

    @GetMapping("/gettripsbypricerange")
    public Flux<Tripdto> getTripsByPriceRange(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return tripService.getTripsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/gettripsbyduration/{duration}")
    public Flux<Tripdto> getTripsByDuration(@PathVariable String duration) {
        return tripService.getTripByDuration(duration);
    }

    @GetMapping("/gettripsbyrating/{rating}")
    public Flux<Tripdto> getTripsByRating(@PathVariable int rating) {
        return tripService.getTripByRating(rating);
    }
}
