package com.example.service;

import com.example.security.Acount;
import com.example.security.Role;

import java.util.List;

public interface IaccountService {

    public Acount addNewAccount(Acount appUser);
    public Role addNewRole(Role appRole);
    public void addRoleToAccount(String username, String roleName);
    public Acount loadUserByUsername(String username);
    public List<Acount> listAccounts();



}
