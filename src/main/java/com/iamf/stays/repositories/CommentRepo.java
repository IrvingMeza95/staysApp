package com.iamf.stays.repositories;

import com.iamf.stays.dtos.comment.CommentLoadDTO;
import com.iamf.stays.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, String> {
    @Query(value = "select * from comment c where c.house_id = :id order by c.posted_date desc", nativeQuery = true)
    List<Comment> findByHouseId(String id);
}
