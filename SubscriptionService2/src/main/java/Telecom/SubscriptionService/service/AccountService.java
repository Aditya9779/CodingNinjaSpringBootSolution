package Telecom.SubscriptionService.service;

import Telecom.SubscriptionService.dto.AccountDto;
import Telecom.SubscriptionService.model.Account;
import Telecom.SubscriptionService.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    public void createAccount(AccountDto accountDto){
        Account account = new Account();
        account.setUser(accountDto.getUser());
        account.setDetails(accountDto.getDetails());
        account.setBalance(accountDto.getBalance());
        accountRepository.save(account);
    }
    public Account updateAccount(Long id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElse(null);
        assert account != null;
        if(accountDto.getUser()!=null) { account.setUser(accountDto.getUser()); }
        if(accountDto.getBalance()!=null) { account.setBalance(accountDto.getBalance()); }
        if(accountDto.getDetails()!=null) { account.setDetails(accountDto.getDetails()); }
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id){
        return this.accountRepository.findById(id)
                .orElse(null);
    }

    public Account getAccountByUserId(Long userId){
        return accountRepository.findByUserId(userId);
    }

    public void deleteAccount(Long id){
        this.accountRepository.deleteById(id);
    }

}
