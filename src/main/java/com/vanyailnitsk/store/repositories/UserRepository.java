package com.vanyailnitsk.store.repositories;

import com.vanyailnitsk.store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
