package com.CodingNinjas.TaxEase.repository;

import com.CodingNinjas.TaxEase.model.TaxRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRecordRepository extends JpaRepository<TaxRecord, Long> {

   /*
     1. Create a method with name "findByUserName" and use derived query to find the list of
        all the tax records by the given username.

     2. The method returns the list of TaxRecord as result.

     3. It takes String userName as input parameter for the method findByUserName.

            List<TaxRecord> findByUserName(String userName);
   */
   List<TaxRecord> findByUserName(String userName);


}
