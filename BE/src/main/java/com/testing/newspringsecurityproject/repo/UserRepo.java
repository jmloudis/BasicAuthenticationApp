package com.testing.newspringsecurityproject.repo;

import com.testing.newspringsecurityproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>
{
    User findUserByUsername(String username);

}
