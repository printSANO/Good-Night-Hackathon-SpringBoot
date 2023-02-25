package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository R_Repository;
    private final RestaurantMapper R_Mapper;

    public Restaurant insertRestaurant(RestaurantCreateRequest restaurantCreateDto) {
        return R_Repository.save(R_Mapper.DtoToEntity(restaurantCreateDto));
    }
    public List<Restaurant> getAllRestaurant() {
        return R_Repository.findAll();
    }
    public List<Restaurant> getRestaurantByCategory(String category) {
        return R_Repository.findByCategory(category);
    }

//    public List<Restaurant> getRestaurantByCategory(String category) {
//        return R_Repository.findByCategory(category);
//    }
}