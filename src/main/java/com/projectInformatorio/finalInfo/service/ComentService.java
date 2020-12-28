package com.projectInformatorio.finalInfo.service;

import com.projectInformatorio.finalInfo.repository.ComentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentService {

@Autowired
ComentRepository comentRepository;
    public void delete(Long id) {
        comentRepository.deleteById(id);
    }

}
