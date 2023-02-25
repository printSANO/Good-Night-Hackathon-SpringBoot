package com.techeer.hackathon.domain.restaurant.repository;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAll();
    List<Restaurant> findByCategory(@Param("category")String category);
    Restaurant findByName(@Param("name")String name);
}