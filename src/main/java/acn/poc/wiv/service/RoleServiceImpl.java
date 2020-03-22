package acn.poc.wiv.service;

import acn.poc.wiv.dao.RoleRepository;
import acn.poc.wiv.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private Environment env;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, Environment env) {
        this.roleRepository = roleRepository;
        this.env = env;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(Role user) {
        roleRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
