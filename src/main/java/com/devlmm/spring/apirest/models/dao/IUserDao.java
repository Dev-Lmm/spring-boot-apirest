package com.devlmm.spring.apirest.models.dao;

import com.devlmm.spring.apirest.models.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface IUserDao extends JpaRepository<User, Long> {
    @Transactional
    Optional<User> findByUsername(String username);

}
