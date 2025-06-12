package com.alexandre.todo.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.alexandre.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUsersByEmailAAndPassword(String email, String password);

    Remapper findUserByEmailAndPassword(String email, String password);
}
