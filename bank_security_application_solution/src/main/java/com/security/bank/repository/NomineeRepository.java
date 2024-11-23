package com.security.bank.repository;

import com.security.bank.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee,Long> {
}
