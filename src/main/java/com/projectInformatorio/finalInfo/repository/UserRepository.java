package com.projectInformatorio.finalInfo.repository;

import com.projectInformatorio.finalInfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public abstract ArrayList<User> findByCity(String city);
    List<User> findByCreationDateIsAfter(LocalDate date);
}
