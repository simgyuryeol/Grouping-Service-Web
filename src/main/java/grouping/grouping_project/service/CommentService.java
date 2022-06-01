package grouping.grouping_project.service;

import grouping.grouping_project.Dto.CommentForm;
import grouping.grouping_project.domain.Comment;
import grouping.grouping_project.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    // 댓글 저장
    @Transactional
    public String save(Long teamId,CommentForm request){
        commentRepository.save(Comment.builder()
                .id(request.getId())
                .team(request.getTeam())
                .content(request.getContent())
                .build());

        return "Success";
    }


}
