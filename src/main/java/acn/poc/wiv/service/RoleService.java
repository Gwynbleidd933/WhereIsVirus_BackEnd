package acn.poc.wiv.service;

import acn.poc.wiv.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> findAll();

    public Optional<Role> findById(int id);

    public void save(Role user);

    public void deleteById(int id);

}
