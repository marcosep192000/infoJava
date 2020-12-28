package com.projectInformatorio.finalInfo.controller;

import com.projectInformatorio.finalInfo.model.Post;
import com.projectInformatorio.finalInfo.model.User;
import com.projectInformatorio.finalInfo.repository.PostRepository;
import com.projectInformatorio.finalInfo.repository.UserRepository;
import com.projectInformatorio.finalInfo.service.PostService;
import com.projectInformatorio.finalInfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @PostMapping("/create")
    public User create(@RequestBody  User user) {
        return  userService.create(user);
    }

    @GetMapping("/list")
    public ResponseEntity<?> lista(){
        return new ResponseEntity<>(userService.list(),HttpStatus.CREATED);
    }

    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Long id) {
        userService.eliminarUsuario(id);
    }
    @GetMapping("/query")
    public ArrayList<User> obtenerUsuarioPorCiudad(@RequestParam("state") String ciudad){
        return this.userService.obtenerPorCiudad(ciudad);
    }

    @GetMapping ("/con")
    public ResponseEntity<?> buscarUsuariosCreadosDespuesDeFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<User> users =userService.obtenerPorFecha(date);
        return new ResponseEntity<>(userService.obtenerPorFecha(date), HttpStatus.OK);
    }

    @PostMapping("/{id_user}/post")
    public ResponseEntity<?> createPostGivenUser(@PathVariable Long id_user, @RequestBody Post post) {
        User user = userRepository.getOne(id_user);
        user.addPost(post);
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }
}

