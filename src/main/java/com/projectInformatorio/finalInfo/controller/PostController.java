package com.projectInformatorio.finalInfo.controller;

import com.projectInformatorio.finalInfo.model.Coment;
import com.projectInformatorio.finalInfo.model.Post;
import com.projectInformatorio.finalInfo.model.User;
import com.projectInformatorio.finalInfo.repository.ComentRepository;
import com.projectInformatorio.finalInfo.repository.PostRepository;
import com.projectInformatorio.finalInfo.service.ComentService;
import com.projectInformatorio.finalInfo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostRepository postRepository;
  @Autowired
  private PostService postService;
  @Autowired
  private ComentRepository comentRepository;
  @Autowired
  private ComentService comentService;
  @GetMapping("/Listar")
  public ResponseEntity<List<Post>> list() {
    return new ResponseEntity<>(postService.list(), HttpStatus.OK);
  }

  @GetMapping("/title")
  public ArrayList<Post> obtenerUsuarioPorCiudad(@RequestParam("title") String title) {
    return this.postService.obtenerPorTitle(title);
  }


  @PostMapping("/{id_post}/coment")
  public ResponseEntity<?> createPostGivenUser(@PathVariable Long id_post, @RequestBody Coment coment) {
   Post post = postRepository.getOne(id_post);
    post.addComent(coment);
    return new ResponseEntity<>(comentRepository.save(coment), HttpStatus.CREATED);
  }
}