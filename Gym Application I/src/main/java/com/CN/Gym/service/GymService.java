package com.CN.Gym.service;

import com.CN.Gym.dto.GymDto;
import com.CN.Gym.exception.GymNotFoundException;
import com.CN.Gym.model.Gym;
import com.CN.Gym.model.User;
import com.CN.Gym.repository.GymRepository;
import com.CN.Gym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    public Gym getGymById(Long id) {
        return gymRepository.findById(id).orElseThrow(() -> new GymNotFoundException("Gym not found with id: " + id));
    }

    public void deleteGymById(Long id) {
        gymRepository.deleteById(id);
    }

    public void updateGym(GymDto gymDto, Long id) {
        Gym existingGym = getGymById(id);
        existingGym.setAddress(gymDto.getAddress());
        existingGym.setFacilities(gymDto.getFacilities());
        existingGym.setName(gymDto.getName());
        existingGym.setMembers(gymDto.getMembers());
        existingGym.setContactNo(gymDto.getContactNo());
        existingGym.setMembershipPlans(gymDto.getMembershipPlans());
        gymRepository.save(existingGym);
    }

    public void createGym(GymDto gymDto) {
        Gym gym = Gym.builder().name(gymDto.getName()).membershipPlans(gymDto.getMembershipPlans())
                .address(gymDto.getAddress()).facilities(gymDto.getFacilities())
                .contactNo(gymDto.getContactNo()).members(gymDto.getMembers()).build();
        gymRepository.save(gym);
    }

    public void addMember(Long userId, Long gymId) {
        User user = userService.getUserById(userId);
        Gym gym = getGymById(gymId);
        List<User> members= gym.getMembers();
        members.add(user);
        gym.setMembers(members);
        user.setGym(gym);
        gymRepository.save(gym);
        userRepository.save(user);
    }

    public void deleteMember(Long userId, Long gymId) {
        User user = userService.getUserById(userId);
        Gym gym = getGymById(gymId);
        if (gym.getMembers().contains(user)) {
            user.setGym(null);
            gym.getMembers().remove(user);
            gymRepository.save(gym);
            userRepository.save(user);
        }
    }
}
