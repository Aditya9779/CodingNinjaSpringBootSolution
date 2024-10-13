package com.CodingNinjas.TaxEase.controller;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import com.CodingNinjas.TaxEase.service.TaxRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tax")
public class TaxRecordController {

    @Autowired
    private TaxRecordService taxRecordService;

    //  1. API: GET "/api/tax/{id}": Fetch a tax Record by its ID.
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaxRecord getTaxRecordById(@PathVariable Long id) {
        return taxRecordService.getTaxRecordById(id);
    }

    // 2. API: GET "/api/tax/all": Fetch all tax records.
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TaxRecord> getAllTaxRecords() {
        return taxRecordService.getAllTaxRecords();
    }

    // 3. API: POST "/api/tax": Create a new tax record using TaxRecordDto.
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createTaxRecord(@RequestBody TaxRecordDto taxRecordDto) {
        taxRecordService.createTaxRecord(taxRecordDto);
    }

    // 4. API: PUT "/api/tax/{id}": Update an existing tax record by ID.
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTaxRecord(@RequestBody TaxRecordDto taxRecordDto, @PathVariable Long id) {
        taxRecordService.updateTaxRecord(taxRecordDto, id);
    }

    // 5. API: DELETE "/api/tax/{id}": Delete a tax record by ID.
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaxRecord(@PathVariable Long id) {
        taxRecordService.deleteTaxRecord(id);
    }

    // 6. API: GET "/api/tax": Fetch tax records by username.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaxRecord> getTaxRecordsByUserName(@RequestParam String userName) {
        return taxRecordService.getTaxRecordsByUserName(userName);
    }

    // 7. API: POST "/api/tax/approve/{id}": Approve a tax record by ID.
    @PostMapping("/approve/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void approveTaxFiling(@PathVariable Long id) {
        taxRecordService.approveTaxFiling(id);
    }

    // 8. API: POST "/api/tax/reject/{id}": Reject a tax record by ID.
    @PostMapping("/reject/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void rejectTaxFiling(@PathVariable Long id) {
        taxRecordService.rejectTaxFiling(id);
    }

}
