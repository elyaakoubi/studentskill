package com.example.service;


import com.example.repo.AcountRepository;
import com.example.repo.RoleRepository;
import com.example.security.Acount;
import com.example.security.MyPasswordEncoder;
import com.example.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService implements IaccountService {

    @Autowired
    AcountRepository accountRepository;

    @Autowired
    RoleRepository appRoleRepository;

    @Autowired
    MyPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Acount addNewAccount(Acount appUser) {
        String pw = appUser.getPassword();
        appUser.setPassword(bCryptPasswordEncoder.encode(pw));
        return accountRepository.save(appUser);
    }

    @Override
    public Role addNewRole(Role appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToAccount(String username, String roleName) {
    Acount user = accountRepository.findByUsername(username);
    Role appRole = appRoleRepository.findByRoleName(roleName);
    user.getRoles().add(appRole);
    }

    @Override
    public Acount loadUserByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Acount> listAccounts() {
        return (List<Acount>) accountRepository.findAll();
    }
}
