package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.exception.TaxRecordNotFoundException;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import com.CodingNinjas.TaxEase.repository.TaxRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxRecordService {

    @Autowired
    private TaxRecordRepository taxRecordRepository;

    // Service method to get a tax record by its ID
    public TaxRecord getTaxRecordById(Long id) {
        return taxRecordRepository.findById(id).orElseThrow(() -> new TaxRecordNotFoundException("Tax Record not found for ID: " + id));
    }

    // Service method to create a new tax record
    public void createTaxRecord(TaxRecordDto taxRecordDto) {
        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setTaxYear(taxRecordDto.getTaxYear());
        taxRecord.setIncome(taxRecordDto.getIncome());
        taxRecord.setUserName(taxRecordDto.getUserName());
        taxRecord.setDeductions(taxRecordDto.getDeductions());
        taxRecord.setFilingApproved(true);
        taxRecordRepository.save(taxRecord);
    }

    // Service method to update an existing tax record
    public void updateTaxRecord(TaxRecordDto taxRecordDto, Long id) {
        TaxRecord taxRecord = getTaxRecordById(id);

        // Update fields from DTO
        taxRecord.setTaxYear(taxRecordDto.getTaxYear());
        taxRecord.setIncome(taxRecordDto.getIncome());
        taxRecord.setUserName(taxRecordDto.getUserName());
        taxRecord.setDeductions(taxRecordDto.getDeductions());

        taxRecordRepository.save(taxRecord);
    }

    // Service method to delete a tax record by ID
    public void deleteTaxRecord(Long id) {
        TaxRecord taxRecord = getTaxRecordById(id);
        if (taxRecord == null) {
            throw new TaxRecordNotFoundException("Not Found the id " + id);
        }
        taxRecordRepository.delete(taxRecord);
    }

    // Service method to approve a tax filing
    public void approveTaxFiling(Long id) {
        TaxRecord taxRecord = getTaxRecordById(id);
        if (taxRecord == null) {
            throw new TaxRecordNotFoundException("Not Found the id " + id);
        }
        taxRecord.setFilingApproved(true);
        taxRecordRepository.save(taxRecord);
    }

    // Service method to reject a tax filing
    public void rejectTaxFiling(Long id) {
        TaxRecord taxRecord = getTaxRecordById(id);
        if (taxRecord == null) {
            throw new TaxRecordNotFoundException("Not Found the id " + id);
        }
        taxRecord.setFilingApproved(false);
        taxRecordRepository.save(taxRecord);
    }

    // Service method to fetch tax records by username
    public List<TaxRecord> getTaxRecordsByUserName(String userName) {
        return taxRecordRepository.findByUserName(userName);
    }

    // Service method to fetch all tax records
    public List<TaxRecord> getAllTaxRecords() {
        return taxRecordRepository.findAll();
    }
}
