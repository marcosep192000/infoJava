package com.projectInformatorio.finalInfo.repository;

import com.projectInformatorio.finalInfo.model.Coment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentRepository extends  JpaRepository<Coment,Long> {



}
