package grouping.grouping_project.controller;

import grouping.grouping_project.Dto.CommentForm;
import grouping.grouping_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {
    private CommentService commentService;

    @PostMapping("/comment/{teamId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void commentSave(@PathVariable("teamId") Long teamId, CommentForm commentForm){
        commentService.save(teamId, commentForm);
    }
}
