package com.example.demo.authrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.authmodels.UserSession;


@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {
	
	public Optional<UserSession> findByUserId(Integer userId);
	
	public Optional<UserSession> findByUUID(String uuid);

}
