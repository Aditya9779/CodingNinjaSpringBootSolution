package com.cn.homeControlSystem.repositories;

import com.cn.homeControlSystem.model.SmartDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Add annotation for this Repository interface.
@Repository
public interface SmartDevicesRepository extends JpaRepository<SmartDevice, Integer> {

    // Create a query method to fetch a device record by name from the database.
    SmartDevice findByName(String name);
}
