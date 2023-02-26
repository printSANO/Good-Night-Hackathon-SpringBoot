package com.techeer.hackathon.domain.restaurant.repository;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("select r from Restaurant r where r.deleted is false")
    Page<Restaurant> findRestaurants(Pageable pageable);
    @Query("select r from Restaurant r where r.deleted is false and r.category = :category")
    Page<Restaurant> findByCategory(@Param("category")String category, Pageable pageable);
}