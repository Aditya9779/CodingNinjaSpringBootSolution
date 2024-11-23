package com.security.bank.admin;

import com.security.bank.dto.AdminDto;
import com.security.bank.entity.Account;
import com.security.bank.entity.AccountType;
import com.security.bank.entity.BranchType;
import com.security.bank.entity.User;
import com.security.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService adminUserService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAdmin(@RequestBody AdminDto admin)
    {
        adminUserService.registerAdmin(admin);
    }

    @GetMapping("/getAllUser")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUser(){
        return adminUserService.getAllUsers();
    }

    @GetMapping("/getUserByName/{username}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public User getUserByName(@PathVariable String username){
        return adminUserService.getUserByName(username);
    }

    @DeleteMapping("/deleteUser/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUserById(@PathVariable Long userId){
        return adminUserService.deleteUserById(userId);
    }

    @PutMapping("/account/deactivate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ADMIN')")
    public String deactivateAccount(@RequestParam Long userId,@RequestParam Long accountId){
    return adminUserService.deactivateUser(userId,accountId);
    }

    @PutMapping("/account/activate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ADMIN')")
    public String activateAccount(@RequestParam Long userId,@RequestParam Long accountId){
        return adminUserService.activateAccount(userId,accountId);
    }

    @GetMapping("/account/getActiveAccountsList")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> activeAccountList(){
       return adminUserService.getAllActiveAccountList();
    }

    @GetMapping("/account/getInActiveAccountsList")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> inActiveAccountList(){
        return adminUserService.getAllInActiveAccountList();
    }

    @GetMapping("/accountList/ByAccountType/{accType}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAccountListByAccType(@PathVariable AccountType accType){
        return adminUserService.byAccType(accType);
    }

    @GetMapping("/accountList/ByBranchType/{branchType}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAccountListByBranchType(@PathVariable BranchType branchType){
        return adminUserService.byBranchType(branchType);
    }

}
