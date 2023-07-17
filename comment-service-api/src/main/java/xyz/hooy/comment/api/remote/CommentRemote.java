package xyz.hooy.comment.api.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hooy.comment.api.entity.Comment;

import java.util.List;

@FeignClient("comment-service")
@RequestMapping("/remote/comment")
public interface CommentRemote {

    @GetMapping("/getCommentById/{id}")
    Comment getCommentById(@PathVariable("id") Long id);

    @GetMapping("/getCommentsByDetailId/{detailId}")
    List<Comment> getCommentsByDetailId(@PathVariable("detailId") Long detailId);

    @GetMapping("/getCommentNamesByDetailId/{detailId}")
    List<String> getCommentNamesByDetailId(@PathVariable("detailId") Long detailId);

    @GetMapping("/getCommentContentsByDetailId/{detailId}")
    List<String> getCommentContentsByDetailId(@PathVariable("detailId") Long detailId);
}
