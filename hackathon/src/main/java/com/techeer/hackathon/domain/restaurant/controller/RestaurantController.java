package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService R_Service;
    private final RestaurantMapper R_Mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RestaurantResponse> createRestaurant(
            @RequestBody @Valid RestaurantCreateRequest restaurantCreateDto) {
        Restaurant insertRestaurant = R_Service.insertRestaurant(restaurantCreateDto);
        return new ResponseEntity(R_Mapper.DtoFromEntity(insertRestaurant), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
}