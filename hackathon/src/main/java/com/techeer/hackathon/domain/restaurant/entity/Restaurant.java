package com.techeer.hackathon.domain.restaurant.entity;

import com.techeer.hackathon.global.util.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public Restaurant(String category, String name) {
        this.category = category;
        this.name = name;
    }
}