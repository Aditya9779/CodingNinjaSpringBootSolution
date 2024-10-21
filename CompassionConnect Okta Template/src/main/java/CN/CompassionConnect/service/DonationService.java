package CN.CompassionConnect.service;

import CN.CompassionConnect.dto.DonationDto;
import CN.CompassionConnect.model.Donation;
import CN.CompassionConnect.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Donation createDonation(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setAmount(donationDto.getAmount());
        donation.setDescription(donationDto.getDescription());
        return donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public Long getTotalDonationAmount() {
        List<Donation> donationList = getAllDonations();
        return donationList.stream()
                .mapToLong(Donation::getAmount)
                .sum();
    }
}
