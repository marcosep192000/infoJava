package com.projectInformatorio.finalInfo.controller;

import com.projectInformatorio.finalInfo.service.ComentService;
import com.projectInformatorio.finalInfo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coment")
public class ComentController {
    @Autowired
    ComentService comentService;
    @Autowired
    PostService postService;


    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Long id) {
        comentService.delete(id);
    }





}
