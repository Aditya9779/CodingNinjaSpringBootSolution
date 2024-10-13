package com.CodingNinjas.LeaveXpress.service;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.exception.LeaveNotFoundException;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public List<LeaveModel> getAcceptedLeaves() {
        return leaveRepository.findByIsAccepted(true);
    }

    public List<LeaveModel> getRejectedLeaves() {
        return leaveRepository.findByIsAccepted(false);
    }

    public boolean getLeaveStatus(Long id) {
        Optional<LeaveModel> leaveModelOpt = leaveRepository.findById(id);
        if (leaveModelOpt.isPresent()) {
            return leaveModelOpt.get().isAccepted() ;
        } else {
            throw new LeaveNotFoundException("Not Found");
        }
    }

    public void updateLeave(Long id, LeaveDto updatedLeave) {
        Optional<LeaveModel> leaveModelOpt = leaveRepository.findById(id);

        if (leaveModelOpt.isPresent()) {
            LeaveModel leaveModel = leaveModelOpt.get();
            leaveModel.setType(updatedLeave.getType());
            leaveModel.setStartDate(updatedLeave.getStartDate());
            leaveModel.setEndDate(updatedLeave.getEndDate());
            leaveModel.setDescription(updatedLeave.getDescription());
            leaveRepository.save(leaveModel); // Save the updated leave model
        }
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    public void applyForLeave(LeaveDto leaveRequest) {
        LeaveModel leaveModel = new LeaveModel();
        leaveModel.setType(leaveRequest.getType());
        leaveModel.setStartDate(leaveRequest.getStartDate());
        leaveModel.setEndDate(leaveRequest.getEndDate());
        leaveModel.setDescription(leaveRequest.getDescription());
//        leaveModel.setAccepted(true); // Leave is pending when initially applied
        leaveRepository.save(leaveModel);
    }

    public void acceptLeave(Long id) {
        Optional<LeaveModel> leaveModelOpt = leaveRepository.findById(id);
        leaveModelOpt.ifPresent(leaveModel -> {
            leaveModel.setAccepted(true);
            leaveRepository.save(leaveModel); // Save the leave with accepted status
        });
    }

    public void rejectLeave(Long id) {
        LeaveModel leaveModelOpt = leaveRepository.findById(id).get();
        if (leaveModelOpt == null) {
            throw new LeaveNotFoundException("Not Found");
        }
        leaveModelOpt.setAccepted(false);
        leaveRepository.save(leaveModelOpt);
    }

    // Helper method to convert LeaveModel to LeaveDto (if necessary)
    private LeaveDto convertToDto(LeaveModel leaveModel) {
        LeaveDto leaveDto = new LeaveDto();
        leaveDto.setType(leaveModel.getType());
        leaveDto.setStartDate(leaveModel.getStartDate());
        leaveDto.setEndDate(leaveModel.getEndDate());
        leaveDto.setDescription(leaveModel.getDescription());
        return leaveDto;
    }

    public LeaveModel getLeaveById(Long id) {
        return leaveRepository.findById(id).orElseThrow(() -> new LeaveNotFoundException("Leave not found with id: " + id));
    }

    public List<LeaveModel> getAllLeaves() {
        return leaveRepository.findAll();
    }
}
