package com.iamf.stays.services;

import com.iamf.stays.dtos.comment.CommentDTO;
import com.iamf.stays.dtos.comment.CommentLoadDTO;
import com.iamf.stays.mappers.CommentMapper;
import com.iamf.stays.models.Comment;
import com.iamf.stays.models.House;
import com.iamf.stays.models.User;
import com.iamf.stays.repositories.CommentRepo;
import com.iamf.stays.repositories.CustomerRepo;
import com.iamf.stays.repositories.FamilyRepo;
import com.iamf.stays.repositories.HouseRepo;
import com.sun.source.doctree.CommentTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private FamilyRepo familyRepo;
    @Autowired
    private HouseRepo houseRepo;
    @Autowired
    private CommentMapper commentMapper;

    public CommentLoadDTO commentHousePost(CommentDTO commentDTO) {
        User user = null;
        if (commentDTO.getUserType().name().equals("CUSTOMER")){
            user = customerRepo.findById(commentDTO.getUserId()).get();
        } else if(commentDTO.getUserType().name().equals("FAMILY")){
            user = familyRepo.findById(commentDTO.getUserId()).get();
        }
        House house = houseRepo.findById(commentDTO.getHouseId()).get();
        Comment comment = Comment.builder()
                .description(commentDTO.getDescription())
                .postedDate(commentDTO.getPostedDate())
                .userId(commentDTO.getUserId())
                .userName(commentDTO.getUserName())
                .userImage(user.getImage())
                .userType(user.getUserType())
                .house(house)
                .build();
        commentRepo.save(comment);
        return commentMapper.commentToCommentLoadDTO(comment);
    }

    public List<CommentLoadDTO> getHouseComments(String id) {
        return commentMapper.commentsToCommentLoadDTOs(commentRepo.findByHouseId(id));
    }
}
