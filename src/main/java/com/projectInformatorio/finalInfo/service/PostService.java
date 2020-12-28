package com.projectInformatorio.finalInfo.service;

import com.projectInformatorio.finalInfo.model.Post;
import com.projectInformatorio.finalInfo.model.User;
import com.projectInformatorio.finalInfo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    public List<Post> list() {
        return postRepository.findAll();
    }

    public ArrayList<Post> obtenerPorTitle(String title) {
        return postRepository.findByTitle(title);
    }


}
