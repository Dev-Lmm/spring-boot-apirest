package com.devlmm.spring.apirest.models.dao;

import com.devlmm.spring.apirest.models.entity.Privilege;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPrivilegeDao extends JpaRepository<Privilege, Long> {
    @Transactional
    @Query(value = "SELECT r.id, r.name FROM roles r WHERE r.name = ?1", nativeQuery = true)
    Optional<Privilege> findByName(String name);
    @Transactional
    Optional<Privilege> findPrivilegeById(Long id);
    @Transactional
    List<Privilege> findAll();
}
