package acn.poc.wiv.dao;

import acn.poc.wiv.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByName(String name);
}
