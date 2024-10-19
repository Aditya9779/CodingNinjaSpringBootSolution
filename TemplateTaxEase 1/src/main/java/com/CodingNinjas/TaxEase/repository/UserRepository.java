package com.CodingNinjas.TaxEase.repository;

import com.CodingNinjas.TaxEase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 1. Add the required annotation over UserRepository.
// 2. Extent the UserRepository with JpaRepository
@Repository
public interface UserRepository extends JpaRepository<User,Long> {}
