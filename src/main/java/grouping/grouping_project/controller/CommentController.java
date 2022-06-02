package grouping.grouping_project.controller;

import grouping.grouping_project.Dto.CommentForm;
import grouping.grouping_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/comment/{teamId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void commentSave(@PathVariable("teamId") Long teamId,@RequestBody CommentForm commentForm){

        commentService.save(commentForm,teamId);
    }

    // 팀 삭제
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity teamDelete(@PathVariable Long commentId){
        if(commentService.commentDelete(commentId).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
