package com.projectInformatorio.finalInfo.controller;

import com.projectInformatorio.finalInfo.service.ComentService;
import com.projectInformatorio.finalInfo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coment")
public class ComentController {
    @Autowired
    ComentService comentService;
    @Autowired
    PostService postService;






}
