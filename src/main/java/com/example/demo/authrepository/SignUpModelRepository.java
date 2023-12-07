package com.example.demo.authrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.authmodels.SignUpModel;

@Repository
public interface SignUpModelRepository extends JpaRepository<SignUpModel, Integer> {
	
	public Optional<SignUpModel> findByUserName(String userName);

}
