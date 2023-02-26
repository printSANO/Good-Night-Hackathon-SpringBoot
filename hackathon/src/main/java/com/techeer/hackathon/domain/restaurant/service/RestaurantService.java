package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository R_Repository;
    private final RestaurantMapper R_Mapper;

    public Restaurant insertRestaurant(RestaurantCreateRequest restaurantCreateDto) {
        return R_Repository.save(R_Mapper.DtoToEntity(restaurantCreateDto));
    }
    public List<RestaurantResponse> getAllRestaurant(Integer size, Integer offSet) {
        Pageable pageable = PageRequest.of(offSet, size);
        return R_Mapper.restaurantResponseListFromEntity(R_Repository.findRestaurants(pageable));
    }
    public List<RestaurantResponse> getRestaurantByCategory(String category, Integer size, Integer offSet) {
        Pageable pageable = PageRequest.of(offSet, size);
//        List<Restaurant> listRestaurant = (List<Restaurant>) R_Repository.findByCategory(category,pageable);
        return R_Mapper.restaurantResponseListFromEntity(R_Repository.findByCategory(category,pageable));
    }

    public RestaurantResponse getRestaurantById(Long id) {
        Restaurant restaurant = R_Repository.findById(id).orElseThrow(RuntimeException::new);
        return R_Mapper.DtoFromEntity(restaurant);
    }
    @Transactional
    public void softDeleteRestaurant(Long id){
        Restaurant restaurant = R_Repository.findById(id).orElseThrow(RuntimeException::new);
        restaurant.delete();
    }
    public RestaurantResponse updateRestaurantCategory(Long id, String newCategory){
        Restaurant restaurant = R_Repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Restaurant not found with id " + id));
        restaurant.setCategory(newCategory);
        R_Repository.save(restaurant);
        return R_Mapper.DtoFromEntity(restaurant);
    }
}