package com.iamf.stays.controllers;

import com.iamf.stays.dtos.comment.CommentDTO;
import com.iamf.stays.dtos.comment.CommentLoadDTO;
import com.iamf.stays.models.Comment;
import com.iamf.stays.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentLoadDTO> commentHousePost(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.commentHousePost(commentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CommentLoadDTO>> getHouseComments(@PathVariable("id") String id){
        return ResponseEntity.ok(commentService.getHouseComments(id));
    }

}
