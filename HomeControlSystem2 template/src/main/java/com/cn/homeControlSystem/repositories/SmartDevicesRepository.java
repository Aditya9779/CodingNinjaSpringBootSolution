package com.cn.homeControlSystem.repositories;

import com.cn.homeControlSystem.model.SmartDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartDevicesRepository extends JpaRepository<SmartDevice, Integer> {

    public SmartDevice findByName(String name);
}
