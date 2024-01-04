package com.iamf.stays.mappers;

import com.iamf.stays.dtos.comment.CommentLoadDTO;
import com.iamf.stays.models.Comment;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentMapper {

    public CommentLoadDTO commentToCommentLoadDTO(Comment comment){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return CommentLoadDTO.builder()
                .id(comment.getId())
                .description(comment.getDescription())
                .postedDate(sdf.format(comment.getPostedDate()))
                .userId(comment.getUserId())
                .userName(comment.getUserName())
                .userImage(comment.getUserImage())
                .userType(comment.getUserType())
                .houseId(comment.getHouse().getId())
                .build();
    }

    public List<CommentLoadDTO> commentsToCommentLoadDTOs(List<Comment> comments){
        List<CommentLoadDTO> commentLoadDTOS = new ArrayList<>();
        comments.forEach((c) -> commentLoadDTOS.add(this.commentToCommentLoadDTO(c)));
        return commentLoadDTOS;
    }

}
