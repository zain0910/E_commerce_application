package com.example.demo.authrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.authmodels.LogInModel;


@Repository
public interface LogInModelRepository extends JpaRepository<LogInModel, Integer>{

}
