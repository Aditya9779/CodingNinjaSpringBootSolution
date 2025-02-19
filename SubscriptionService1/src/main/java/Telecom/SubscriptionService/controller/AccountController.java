package Telecom.SubscriptionService.controller;

import Telecom.SubscriptionService.Exception.InternalServerError;
import Telecom.SubscriptionService.Exception.NotFoundException;
import Telecom.SubscriptionService.dto.AccountDto;
import Telecom.SubscriptionService.dto.ResponseMessage;
import Telecom.SubscriptionService.model.Account;
import Telecom.SubscriptionService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountById(@PathVariable Long id) throws NotFoundException {
        return accountService.getAccountById(id);
    }

    @GetMapping("/userId/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountByUserId(@PathVariable Long userId) throws NotFoundException{
        return accountService.getAccountByUserId(userId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@PathVariable Long id, @RequestBody AccountDto accountDto) throws NotFoundException{
        return  accountService.updateAccount(id, accountDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createAccount(@RequestBody AccountDto accountDto) throws InternalServerError {
        accountService.createAccount(accountDto);
        return new ResponseMessage("Account Created Successfully");
    }

    @DeleteMapping
    public ResponseMessage deleteAccount(@PathVariable Long id) throws InternalServerError{
        accountService.deleteAccount(id);
        return new ResponseMessage("Account Successfully Deleted");
    }

}
