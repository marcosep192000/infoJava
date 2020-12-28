package com.projectInformatorio.finalInfo.service;

import com.projectInformatorio.finalInfo.model.Post;
import com.projectInformatorio.finalInfo.model.User;
import com.projectInformatorio.finalInfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User create( User user)
    {
        return userRepository.save(user);
    }

    public User update ( User user)
    {
        return userRepository.save(user);
    }




    public List<User> list()
    {
        return userRepository.findAll();

    }

    public void  eliminarUsuario(Long id) {
     userRepository.deleteById(id);
    }

    public ArrayList<User> obtenerPorCiudad(String city) {
        return userRepository.findByCity(city) ;
    }

    public ArrayList<User> obtenerPorFecha(LocalDate date) {
        return (ArrayList<User>) userRepository.findByCreationDateIsAfter(date);
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

}

