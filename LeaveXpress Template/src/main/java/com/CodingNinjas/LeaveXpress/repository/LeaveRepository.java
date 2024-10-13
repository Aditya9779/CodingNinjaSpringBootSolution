package com.CodingNinjas.LeaveXpress.repository;


import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeaveRepository extends JpaRepository<LeaveModel, Long> {
    List<LeaveModel> findByIsAccepted(boolean b);
}
