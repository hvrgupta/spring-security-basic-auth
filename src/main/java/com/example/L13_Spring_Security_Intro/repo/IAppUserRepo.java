package com.example.L13_Spring_Security_Intro.repo;

import com.example.L13_Spring_Security_Intro.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
