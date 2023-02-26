package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService R_Service;
    private final RestaurantMapper R_Mapper;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RestaurantResponse> createRestaurant(
            @RequestBody @Valid RestaurantCreateRequest restaurantCreateDto) {
        Restaurant insertRestaurant = R_Service.insertRestaurant(restaurantCreateDto);
        return new ResponseEntity(R_Mapper.DtoFromEntity(insertRestaurant), HttpStatus.CREATED);
    }

    @GetMapping("/page")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurant(
            @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "0") Integer offset) {
        return ResponseEntity.ok(R_Service.getAllRestaurant(size, offset));
    }

    @GetMapping("/category")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantByCategory(
            @RequestParam("category") String category, @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "0") Integer offset) {
        return ResponseEntity.ok(R_Service.getRestaurantByCategory(category, size, offset));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getRestaurantById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(R_Service.getRestaurantById(id));
    }
//    @PutMapping(/)


}