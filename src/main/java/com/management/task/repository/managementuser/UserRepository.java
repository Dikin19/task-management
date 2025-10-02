package com.management.task.repository.managementuser;

import com.management.task.entity.managementuser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

}
