package com.projectInformatorio.finalInfo.repository;

import com.projectInformatorio.finalInfo.model.Post;
import com.projectInformatorio.finalInfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    public abstract ArrayList<Post> findByTitle(String title);
}
