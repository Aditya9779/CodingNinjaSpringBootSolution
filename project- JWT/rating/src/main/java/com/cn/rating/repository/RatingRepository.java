package com.cn.rating.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cn.rating.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
