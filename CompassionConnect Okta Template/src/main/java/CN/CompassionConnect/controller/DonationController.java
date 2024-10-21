package CN.CompassionConnect.controller;

import CN.CompassionConnect.dto.DonationDto;
import CN.CompassionConnect.model.Donation;
import CN.CompassionConnect.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('NORMAL')")
    public ResponseEntity<Donation> createDonation(@RequestBody DonationDto donationDto) {
        Donation newDonation = donationService.createDonation(donationDto);
        return ResponseEntity.ok(newDonation);
    }

    @GetMapping("getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Donation> getAllDonations(){
        return donationService.getAllDonations();
    }

    @GetMapping("getTotalAmount")
    @PreAuthorize("hasRole('ADMIN')")
    public Long getTotalDonationAmount(){
        return donationService.getTotalDonationAmount();
    }

}
