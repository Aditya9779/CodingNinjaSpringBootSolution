package com.CodingNinjas.TaxEase.repository;

import com.CodingNinjas.TaxEase.model.TaxRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRecordRepository extends JpaRepository<TaxRecord, Long> {

    List<TaxRecord> findByUserName(String userName);

}
