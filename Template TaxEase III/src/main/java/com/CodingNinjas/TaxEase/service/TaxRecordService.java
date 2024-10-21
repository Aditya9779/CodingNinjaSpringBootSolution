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

    public TaxRecord getTaxRecordById(Long id) {
        return taxRecordRepository.findById(id)
                .orElseThrow(() -> new TaxRecordNotFoundException("Tax Record is not found for id: " + id));
    }


    public List<TaxRecord> getAllRecords() {
        return taxRecordRepository.findAll();
    }

    public void createTaxRecord(TaxRecordDto taxRecordDto) {
        TaxRecord taxRecord = TaxRecord.builder().userName(taxRecordDto.getUserName())
                .taxYear(taxRecordDto.getTaxYear()).deductions(taxRecordDto.getDeductions())
                .Income(taxRecordDto.getIncome()).build();
        taxRecordRepository.save(taxRecord);
    }

    public void updateTaxRecord(TaxRecordDto taxRecordDto, Long id) {
        TaxRecord existingRecord = getTaxRecordById(id);
        existingRecord.setUserName(taxRecordDto.getUserName());
        existingRecord.setTaxYear(taxRecordDto.getTaxYear());
        existingRecord.setIncome(taxRecordDto.getIncome());
        existingRecord.setDeductions(taxRecordDto.getDeductions());
        taxRecordRepository.save(existingRecord);
    }

    public void deleteTaxRecord(Long id) {
        taxRecordRepository.deleteById(id);
    }

    public List<TaxRecord> getRecordsByName(String userName) {
        return taxRecordRepository.findByUserName(userName);
    }

    public void approveTaxFiling(Long id) {
        TaxRecord existingRecord = getTaxRecordById(id);
        existingRecord.setFilingApproved(true);
        taxRecordRepository.save(existingRecord);
    }

    public void rejectTaxFiling(Long id) {
        TaxRecord existingRecord = getTaxRecordById(id);
        existingRecord.setFilingApproved(false);
        taxRecordRepository.save(existingRecord);
    }
}
