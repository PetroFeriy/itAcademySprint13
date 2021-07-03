package com.example.demo.service;


import com.example.demo.DAO.RoleRepository;
import com.example.demo.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService implements BaseService<Role> {

    private final RoleRepository roleRepository;

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
