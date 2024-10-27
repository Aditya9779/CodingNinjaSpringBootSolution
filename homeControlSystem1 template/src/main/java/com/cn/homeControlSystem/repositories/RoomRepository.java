package com.cn.homeControlSystem.repositories;

import com.cn.homeControlSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//extend JpaRepository with relevant generic types.
//add annotation for this Repository interface.
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
