package com.security.bank.service;

import com.security.bank.dto.AdminDto;
import com.security.bank.dto.UserDto;
import com.security.bank.entity.*;
import com.security.bank.repository.AccountRepository;
import com.security.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public void registerUser(UserDto userDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userDto.getPassword());
        Role role = new Role();
        role.setRoleName("ROLE_CUSTOMER");
        User saveUser = new User();
        saveUser.setName(userDto.getName());
        saveUser.setPassword(encodedPassword);
        saveUser.setUsername(userDto.getUsername());
        saveUser.setIdentityProof(userDto.getIdentityProof());
        saveUser.setNumber(userDto.getNumber());
        saveUser.setRoles(role);
        saveUser.setAddress(userDto.getAddress());
        userRepository.save(saveUser);
    }

    public void registerAdmin(AdminDto adminDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(adminDto.getPassword());
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        User saveUser = new User();
        saveUser.setName(adminDto.getName());
        saveUser.setPassword(encodedPassword);
        saveUser.setUsername(adminDto.getUsername());
        saveUser.setIdentityProof(adminDto.getIdentityProof());
        saveUser.setNumber(adminDto.getNumber());
        saveUser.setRoles(role);
        saveUser.setAddress(adminDto.getAddress());
        userRepository.save(saveUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username).get();
    }

    public String deleteUserById(Long userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return "Deleted Successfully";
        }
         return "Error in deletion";
    }

    public String deactivateUser(Long userId,Long accountId) {
        if(userRepository.existsById(userId) && accountRepository.existsById(accountId)){
            User user = userRepository.findById(userId).get();
            Account account = accountRepository.findById(accountId).get();
            if(user.getAccountList().contains(account)){
                System.out.println("Account Found");
                account.setStatus("INACTIVE");
                accountRepository.save(account);
            }
            return "Deactivated Account for User with id: "+userId;
        }
        return "ERROR";
    }

    public String activateAccount(Long userId, Long accountId) {
        if(userRepository.existsById(userId) && accountRepository.existsById(accountId)){
            User user = userRepository.findById(userId).get();
            Account account = accountRepository.findById(accountId).get();
            if(user.getAccountList().contains(account) && account.getStatus().equals("INACTIVE")){
                System.out.println("1 Account Found");
                account.setStatus("ACTIVE");
                accountRepository.save(account);
                return "Activated Account for User with id: "+userId;
            }
        }
        return "ERROR";
    }

    public List<Account> getAllActiveAccountList() {
        return accountRepository.findAllActiveAccounts();
    }

    public List<Account> getAllInActiveAccountList() {
        return accountRepository.findAllInActiveAccounts();
    }


    public List<Account> byAccType(AccountType accType) {
        return accountRepository.findAllByAccountType(accType);
    }

    public List<Account> byBranchType(BranchType branchType) {
        return accountRepository.findAllByBranch(branchType);
    }
}
